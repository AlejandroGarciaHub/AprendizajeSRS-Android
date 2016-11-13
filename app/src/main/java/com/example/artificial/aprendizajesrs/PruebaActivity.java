package com.example.artificial.aprendizajesrs;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PruebaActivity extends AppCompatActivity {

    DataBaseHelper helper;

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    String palabraActual;
    String respuesta;

    int id;

    int cantidadMaxima = 10, cantidad = 1;

    ImageView image;

    int categoria = 0;

    Toast toast;

    TextView res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_prueba);
        helper = new DataBaseHelper(this);
        image = (ImageView) findViewById(R.id.imageMain);
        res = (TextView) findViewById(R.id.tvTit);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);

        Button btnSig = (Button) findViewById(R.id.btnSiguiente);

        rb1 = (RadioButton) findViewById(R.id.rbOpcion1);
        rb2 = (RadioButton) findViewById(R.id.rbOpcion2);
        rb3 = (RadioButton) findViewById(R.id.rbOpcion3);
        rb4 = (RadioButton) findViewById(R.id.rbOpcion4);

        helper.repasadoFalse();
        toast = new Toast(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        try {
            categoria = bundle.getInt("CATEGORIA");
        } catch (Exception ex) {

        }

        if (categoria == 0) {
            AlertDialog ad = new AlertDialog.Builder(PruebaActivity.this).create();
            ad.setTitle("¡Hola!");
            ad.setMessage("Bienvenido de vuelta, ¿Listo para repasar? Procura no equivocarte mucho para no tener demasiadas" +
                    " palabras por revisar la proxima vez");
            ad.setButton("De acuerdo", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    getPalabra();

                }
            });

            ad.show();

        } else {
            AlertDialog ad = new AlertDialog.Builder(PruebaActivity.this).create();
            ad.setTitle("¡Hola!");
            ad.setMessage("Trata de mejorar en esta categoria, adelante!");
            ad.setButton("De acuerdo", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    getPalabraCategoria();

                }
            });
            ad.show();
        }

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                toast.cancel();
                try {
                    if (respuesta.equals(palabraActual)) {
                        helper.guardarResultado(id,3);
                        toast = Toast.makeText(PruebaActivity.this, "Excelente", Toast.LENGTH_SHORT);
                        toast.show();

                    } else {
                        helper.guardarResultado(id,2);
                        toast = Toast.makeText(PruebaActivity.this, "Respuesta incorrecta", Toast.LENGTH_SHORT);
                        toast.show();

                    }


                    if (cantidadMaxima == cantidad) {

                        if (categoria == 0) {
                            AlertDialog ad = new AlertDialog.Builder(PruebaActivity.this).create();
                            ad.setTitle("Listo");
                            ad.setMessage("Has revisado aquellas palabras que mas olvidadas tenias, producura no " +
                                    "revisar demasiadas veces un mismo dia, de lo contrario no retendras las palabras" +
                                    " que has repasado\nNos vemos!");
                            ad.setButton("De acuerdo", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(PruebaActivity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            });
                            ad.show();

                        } else {

                            AlertDialog ad = new AlertDialog.Builder(PruebaActivity.this).create();
                            ad.setTitle("Listo");
                            ad.setMessage("Listo, dentro de algun tiempo intenta esta categoria y observa que tantas palabras recuerdas ");
                            ad.setButton("De acuerdo", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {

                                    Intent i = new Intent(PruebaActivity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            });
                            ad.show();


                        }
                    } else if (respuesta.isEmpty()) {
                        toast = Toast.makeText(PruebaActivity.this, "Selecciona una opcion", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {

                        cantidad++;
                        rg.clearCheck();
                        if (categoria == 0) {
                            getPalabra();
                        } else {
                            getPalabraCategoria();
                        }
                    }

                } catch (Exception ex) {
                    toast = Toast.makeText(PruebaActivity.this, "Selecciona una opcion", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    respuesta = rb1.getText().toString();
                }
            }
        });
        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    respuesta = rb2.getText().toString();
                }
            }
        });
        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    respuesta = rb3.getText().toString();
               }
            }
        });
        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    respuesta = rb4.getText().toString();
                }
            }
        });


    }

    public void getPalabra() {
        respuesta = "";
        String palabra[] = helper.getPalabra();
        int id = Integer.parseInt(palabra[0]);
        String palabraActual = palabra[1];
        int categoria = Integer.parseInt(palabra[2]);
        String otra1 = palabra[3];
        String otra2 = palabra[4];
        String otra3 = palabra[5];

        String palabrasOpciones[] = {palabraActual, otra1, otra2, otra3};
        String opcionesRandom[] = shuffleArray(palabrasOpciones);

        rb1.setText(opcionesRandom[0]);
        rb2.setText(opcionesRandom[1]);
        rb3.setText(opcionesRandom[2]);
        rb4.setText(opcionesRandom[3]);

   //     res.setText(id + " " + palabraActual + ": " + respuesta);
        getImage(id, categoria);

        this.id=id;

        this.palabraActual = palabraActual;

    }

    public void getPalabraCategoria() {
        respuesta = "";
        String palabra[] = helper.getPalabraCategoria(categoria);
        int id = Integer.parseInt(palabra[0]);
        String palabraActual = palabra[1];
        int categoria = Integer.parseInt(palabra[2]);
        String otra1 = palabra[3];
        String otra2 = palabra[4];
        String otra3 = palabra[5];

        String palabrasOpciones[] = {palabraActual, otra1, otra2, otra3};
        String opcionesRandom[] = shuffleArray(palabrasOpciones);

        rb1.setText(opcionesRandom[0]);
        rb2.setText(opcionesRandom[1]);
        rb3.setText(opcionesRandom[2]);
        rb4.setText(opcionesRandom[3]);

        getImage(id, categoria);
        this.id=id;


        this.palabraActual = palabraActual;

    }

    void getImage(int id, int categoria) {
        int imagesAnimales[] = {R.drawable.abeja, R.drawable.cangrejo, R.drawable.elefante, R.drawable.hormiga,
                R.drawable.lagarto, R.drawable.mariposa, R.drawable.murcielago, R.drawable.oso, R.drawable.pajaro,
                R.drawable.pato, R.drawable.perro, R.drawable.pez, R.drawable.toro, R.drawable.vaca};

        int imagesFrutas[] = {R.drawable.ceraza, R.drawable.fresa, R.drawable.kiwi, R.drawable.manzana,
                R.drawable.naranja, R.drawable.pera, R.drawable.pina, R.drawable.platanos, R.drawable.sandia,
                R.drawable.uvas};

        int imagesObjetos[] = {R.drawable.atomizador, R.drawable.cesto, R.drawable.cubeta, R.drawable.fibra,
                R.drawable.guante, R.drawable.lavadora, R.drawable.maceta, R.drawable.matamoscas, R.drawable.plancha,
                R.drawable.recogedor};

        int imagesColores[] = {R.drawable.amarillo, R.drawable.azul, R.drawable.blanco, R.drawable.celeste,
                R.drawable.gris, R.drawable.morado, R.drawable.naranja, R.drawable.negro, R.drawable.rojo,
                R.drawable.verde};

        int imagesPrendas[] = {R.drawable.bolso, R.drawable.brasier, R.drawable.camiseta, R.drawable.corbata,
                R.drawable.minifalda, R.drawable.playera, R.drawable.ropa_interior, R.drawable.sandalias, R.drawable.shorts, R.drawable.tachones,
                R.drawable.tenis};

        int imagesFormas[] = {R.drawable.circulo, R.drawable.cuadrado, R.drawable.eneagono, R.drawable.estrella,
                R.drawable.hexagono, R.drawable.octagono, R.drawable.pentagono, R.drawable.triangulo};


        if (categoria == 1) {
            image.setImageResource(imagesAnimales[id - 1]);
        } else if (categoria == 2) {
            image.setImageResource(imagesFrutas[id - imagesAnimales.length - 1]);
        } else if (categoria == 3) {
            image.setImageResource(imagesObjetos[id - imagesAnimales.length - imagesFrutas.length - 1]);
        } else if (categoria == 4) {
            image.setImageResource(imagesColores[id - imagesAnimales.length - imagesObjetos.length - imagesFrutas.length - 1]);
        } else if (categoria == 5) {
            image.setImageResource(imagesPrendas[id - imagesAnimales.length - imagesObjetos.length - imagesFrutas.length
                    - imagesColores.length - 1]);
        } else if (categoria == 6) {
            image.setImageResource(imagesFormas[id - imagesAnimales.length - imagesObjetos.length - imagesColores.length
                    - imagesPrendas.length - imagesFrutas.length - 1]);
        }
    }


    String[] shuffleArray(String[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

}
