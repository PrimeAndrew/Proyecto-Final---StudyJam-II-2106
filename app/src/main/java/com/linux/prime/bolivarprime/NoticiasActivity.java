package com.linux.prime.bolivarprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoticiasActivity extends AppCompatActivity {

    private DatabaseReference goles = FirebaseDatabase.getInstance().getReference().child("Gol");
    private DatabaseReference mensajeRef= FirebaseDatabase.getInstance().getReference().child("Bolivar").child("scores");
    private DatabaseReference init = FirebaseDatabase.getInstance().getReference().child("Comienzo");

    private TextView tv_sc1;
    private TextView tv_sc2;
    private TextView tv_time;
    private TextView tv_act;
    private TextView tv_win;

    private String golt="0";
    private String  www = "";
    private int stt = 0 ;

    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference ref = database.getReference();
    //private DatabaseReference mensajeRef = ref.child("Bolivar").child("scores");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        getSupportActionBar().hide();
        tv_sc1 = (TextView)findViewById(R.id.tv_sc1);
        tv_sc2 = (TextView)findViewById(R.id.tv_sc2);
        tv_time = (TextView)findViewById(R.id.tv_time);
        tv_act = (TextView)findViewById(R.id.tv_act);
        tv_win = (TextView)findViewById(R.id.tv_win);

    }

    @Override
    protected void onStart() {
        try {
            super.onStart();

            init.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    stt = dataSnapshot.getValue(Integer.class);
                    switch (stt) {
                        case 0:
                            tv_act.setText("PARTIDO NO INICIADO");
                            break;
                        case 1:
                            tv_act.setText("PARTIDO EN CURSO");
                            Toast.makeText(getApplicationContext(), "C O M I E N Z O", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            tv_act.setText("PARTIDO FINALIZADO");
                            Toast.makeText(getApplicationContext(), "F I N A L", Toast.LENGTH_SHORT).show();

                            break;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            goles.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int glt = dataSnapshot.getValue(Integer.class);
                    golt = (glt + "");
                    // System.out.println("Valor1: |"+golt+"|");
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Error goles", Toast.LENGTH_SHORT).show();
                }
            });

            mensajeRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //System.out.println("Valor2: |"+golt+"|");
                    /*int value1 = dataSnapshot.child(golt).child("sc1").getValue(Integer.class);
                    int value2 = dataSnapshot.child(golt).child("sc2").getValue(Integer.class);
                    int value3 = dataSnapshot.child(golt).child("time").getValue(Integer.class);*/
                    int value1 = dataSnapshot.child("static").child("sc1").getValue(Integer.class);
                    int value2 = dataSnapshot.child("static").child("sc2").getValue(Integer.class);
                    int value3 = dataSnapshot.child("static").child("time").getValue(Integer.class);

                    if (value1 == value2 && stt == 2) {
                        www = "FINAL: Tablas";
                    } else {
                        if (value1 > value2 && stt == 2) {
                            www = "FINAL: Ganador Bolivar";
                        } else {
                            if (value1 < value2 && stt == 2) {
                                www = "FINAL: Ganador The Strongest";
                            } else {
                                if (value1 == value2 && stt == 1) {
                                    www = "Tablas";
                                } else {
                                    if (value1 > value2 && stt == 1) {
                                        www = "Ganador Bolivar";
                                    } else {
                                        if (value1 < value2 && stt == 1) {
                                            www = "Ganador The Strongest";
                                        } else {
                                            Toast.makeText(getApplicationContext(), "N O  I N I C I A D O", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }
                    }


                    tv_sc1.setText(value1 + "");
                    tv_sc2.setText(value2 + "");
                    tv_time.setText(value3 + "");
                    tv_win.setText(www);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "ERROR 001", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            //Toast.makeText(getApplicationContext(), "NO HAY PARTIDOS A JUGARSE", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();

        }
    }
}
