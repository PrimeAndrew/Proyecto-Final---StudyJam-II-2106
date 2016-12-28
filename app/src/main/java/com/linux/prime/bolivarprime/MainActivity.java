package com.linux.prime.bolivarprime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }
    public void noticias(View view){
        Intent i = new Intent(getApplicationContext(),NoticiasActivity.class);
        startActivity(i);
    }
    public void canticos(View view){
        Intent i = new Intent(getApplicationContext(),CanticosActivity.class);
        startActivity(i);
    }
    public void acerca (View view){
        Toast.makeText(getApplicationContext(), "CREADO POR: Ronald Aparicio - /*prime*/ U.C.B.", Toast.LENGTH_LONG).show();
    }
}
