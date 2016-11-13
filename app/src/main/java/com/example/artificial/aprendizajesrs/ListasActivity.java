package com.example.artificial.aprendizajesrs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_listas);


        ListView lv = (ListView) findViewById(R.id.listview_listas);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> array = new ArrayList<String>();
        array.add("Animales");
        array.add("Frutas");
        array.add("Objetos");
        array.add("Colores");
        array.add("Prendas");
        array.add("Formas Geometricas");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.custom_list_white,
                array);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(ListasActivity.this,PruebaActivity.class);
                i.putExtra("CATEGORIA",position+1);
                startActivity(i);
            }
        });
    }

}
