package com.example.artificial.aprendizajesrs;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 11/11/16.
 */

public class LogrosActivity extends AppCompatActivity {

    DataBaseHelper helper=new DataBaseHelper(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.logros_layout);

        ListView lv = (ListView) findViewById(R.id.listLogros);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> array = new ArrayList<String>();


         if (helper.getPuntuacion()<10){
             array.add("• Practica para lograr tu primer logro, podras verlos desde aqui");
             array.add("• ");
            array.add("• ");
            array.add("• ");
        }
        if (helper.getPuntuacion()>=10&&helper.getPuntuacion()<50){
            array.add("• Has logrado acertar 10");
        }
        else if (helper.getPuntuacion()>=50&&helper.getPuntuacion()<100){

            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
        }
        else if(helper.getPuntuacion()>=100&&helper.getPuntuacion()<200){

            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
            array.add("• Has logrado acertar 100");
        }
        else if(helper.getPuntuacion()>=200&&helper.getPuntuacion()<300){
            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
            array.add("• Has logrado acertar 100");
            array.add("• Has logrado acertar 200");
        }
        else if(helper.getPuntuacion()>=300&&helper.getPuntuacion()<400){
            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
            array.add("• Has logrado acertar 100");
            array.add("• Has logrado acertar 200");
            array.add("• Has logrado acertar 300");
        }
        else if(helper.getPuntuacion()>=400&&helper.getPuntuacion()<500){
            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
            array.add("• Has logrado acertar 100");
            array.add("• Has logrado acertar 200");
            array.add("• Has logrado acertar 300");
            array.add("• Has logrado acertar 400");
        }
        else if(helper.getPuntuacion()>=500){
            array.add("• Has logrado acertar 10");
            array.add("• Has logrado acertar 50");
            array.add("• Has logrado acertar 100");
            array.add("• Has logrado acertar 200");
            array.add("• Has logrado acertar 300");
            array.add("• Has logrado acertar 400");
            array.add("• Has logrado acertar 500");
        }

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.custom_list_white_left,
                array);

        lv.setAdapter(arrayAdapter);
    }
}
