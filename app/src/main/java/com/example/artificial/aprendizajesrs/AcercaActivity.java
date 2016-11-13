package com.example.artificial.aprendizajesrs;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by alex on 6/11/16.
 */

public class AcercaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.acerca);

        TextView tvQ=(TextView) findViewById(R.id.tvQue);
        TextView tvC=(TextView) findViewById(R.id.tvComo);

        tvQ.setText("El SRS (Sistema de Repetición Espaciada) es un método de presentación que te da la información antes de que la vayas a olvidar, y se asegura de que dicha información se mantenga constantemente fresca en tu mente.\n" +
                "\n" +
                "Así, puede que veas la palabra en unos pocos minutos después de la primera vez, luego unos días después, luego unas semanas después, etc., siempre en el momento que más necesites verla para asegurar de que se mantenga constantemente fresca en tu mente.");

        tvC.setText("Progresa repasando las palabras que la aplicacion te sugiere, de esta forma estaras repasando aquellas palabras en donde mas te equivoques.\n"
                +"De misma forma, puedes repasar una categoria de palabras seleccionandola desde el apartado LISTAS\n"+
                "Conforme vayas avanzando, iras cumpliendo distintos logros que podras ver desbloqueados.");
    }


}
