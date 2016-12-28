package com.linux.prime.bolivarprime;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CanticoFinalActivity extends AppCompatActivity {

    private TextView tvCTitulo;
    private TextView tvCLetra;
    private TextView tvCLLetra;

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;

    private MediaPlayer mediaPlayer;

   // private Typeface tf_thing;
    //private Typeface tf_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantico_final);
        getSupportActionBar().hide();


        tvCTitulo = (TextView) findViewById(R.id.tvCTitulo);
        tvCLetra = (TextView) findViewById(R.id.tvCLetra);
        tvCLLetra = (TextView) findViewById(R.id.tvCLLetra);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);

        Songs songs = (Songs) getIntent().getSerializableExtra("songs");

        //tf_thing = Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");
       // tf_bold = Typeface.createFromAsset(getAssets(), "fonts/roboto_black.ttf");

        //tvCTitulo.setTypeface(tf_bold);
        //tvHAbilidades.setTypeface(tf_thing);


        tvCTitulo.setText(songs.getTitulo());
        tvCLetra.setText(songs.getLetra());
        tvCLLetra.setText(songs.getLLetra());

        initUI();
        initMediaPlayer();

    }
    public void initUI() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    public void initMediaPlayer() {
        String canti = tvCTitulo.getText().toString();
        if (canti.equals("Vengo por que te quiero")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico1);
        }
        if (canti.equals("Me voy a ver a Bolivar")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico2);
        }
        if (canti.equals("Señores soy del Bolivar")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico3);
        }
        if (canti.equals("Vamos A K D")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico4);
        }
        if (canti.equals("Bolivarista señores soy yo")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico5);
        }
        if (canti.equals("Bolivarista de corazón")){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cantico6);
        }



    }

    public void play(View view) {
        try {
            Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);
            btnPlay.setEnabled(false);
        } catch (IllegalStateException e){
            Log.i("MediaPlayer", "Error: "+e.getMessage());
        }
    }
    public void pause(View view) {
        if(mediaPlayer.isPlaying()) {
            Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT).show();
            mediaPlayer.pause();
            btnPlay.setEnabled(true);
            btnStop.setEnabled(false);
            btnStop.setHintTextColor(100);
        }
    }
    public void stop(View view) {
        if(mediaPlayer.isPlaying()){
            Toast.makeText(getApplicationContext(), "Detenido", Toast.LENGTH_SHORT).show();
            mediaPlayer.stop();
            mediaPlayer.release();
            initMediaPlayer();
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
           // Toast.makeText(getApplicationContext(), "Detenido", Toast.LENGTH_SHORT).show();
            mediaPlayer.stop();
            mediaPlayer.release();
            initMediaPlayer();
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
        }

    }
}
