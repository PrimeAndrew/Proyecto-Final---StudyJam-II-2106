package com.linux.prime.bolivarprime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CanticosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvDatos;
    private Activity activity;
    private CustomAdapter adaptador;
    private ArrayList<Songs> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canticos);
        getSupportActionBar().hide();

        lvDatos = (ListView) findViewById(R.id.lvLista);
        activity = this;
        datos = new ArrayList<Songs>();

        llenarArrayList();
        adaptador = new CustomAdapter(activity, datos);
        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(this);
    }
    public void llenarArrayList() {
        Resources resources = getResources();
        String[] arrayTitulos = resources.getStringArray(R.array.titulos);
        String[] arrayLetras = resources.getStringArray(R.array.letras);
        String[] arrayLLetras = resources.getStringArray(R.array.lletras);
        for (int i = 0; i < arrayTitulos.length; i++) {
            datos.add(new Songs(arrayTitulos[i], arrayLetras[i],arrayLLetras[i]));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Songs songs = datos.get(position);
        Intent intent = new Intent(
                getApplicationContext(),
                CanticoFinalActivity.class
        );
        intent.putExtra("songs", songs);
        startActivity(intent);
    }
}
