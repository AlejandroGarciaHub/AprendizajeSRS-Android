package com.example.artificial.aprendizajesrs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

/**
 * Created by alex on 9/11/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=8;
    private static final String DATABASE_NAME="aprendizaje.db";
    private static final String TABLE_PALABRAS="palabras";

    private static final String COLUMN_ID="id";
    private static final String COLUMN_PALABRA="palabra";
    private static final String COLUMN_EQUIVOCADAS="equivocadas";
    private static final String COLUMN_CORRECTAS="correctas";
    private static final String COLUMN_CATEGORIA="categoria";
    private static final String COLUMN_REPASADO="repasado";
    SQLiteDatabase db;

    private static final String TABLE_PALABRAS_CREATE="create table palabras (" +
            "id integer primary key not null," +
            " palabra text not null, " +
            "equivocadas int not null," +
            "correctas int not null, " +
            "categoria int not null, repasado int not null)";

    public  DataBaseHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_PALABRAS_CREATE);

        //Animales
        String animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Abeja',0,0,1, 0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Cangrejo',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Elefante',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Hormiga',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Lagarto',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Mariposa',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Murcielago',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Oso',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Pajaro',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Pato',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Perro',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Pez',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Toro',0,0,1,0)";
        db.execSQL(animal);
        animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Vaca',0,0,1,0)";
        db.execSQL(animal);

        //Frutas

        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Cereza',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Fresa',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Kiwi',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Manzana',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Naranja',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Pera',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Piña',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Platanos',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Sandia',0,0,2,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Uvas',0,0,2,0)");


        //Objetos

        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Atomizador',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Cesto',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Cubeta',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Fibra',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Guante',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Lavadora',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Maceta',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Matamoscas',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Plancha',0,0,3,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Recogedor',0,0,3,0)");

        //Colores

        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Amarillo',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Azul',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Blanco',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Celeste',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Gris',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Morado',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Naranja',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Negro',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Rojo',0,0,4,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Verde',0,0,4,0)");

        //Prendas

        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Bolso',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Sosten',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Playera',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Corbata',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Falda',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Camiseta',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Ropa Interior',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Sandalias',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Short',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Tachones',0,0,5,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Tenis',0,0,5,0)");

        //Formas
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Circulo',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Cuadrado',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Eneagono',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Estrella',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Hexagono',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Octagono',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Pentagono',0,0,6,0)");
        db.execSQL("INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('Triangulo',0,0,6,0)");


        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS "+TABLE_PALABRAS;
        db.execSQL(query);


        this.onCreate(db);

    }


    public void insertar(String par1,int par2, int par3,int par4){
        String animal="INSERT INTO "+TABLE_PALABRAS+" (palabra,equivocadas, correctas, categoria,repasado) values ('"+par1+"',"+par2+","+par3+","+par4+")";
        db.execSQL(animal);
    }

    public void repasadoFalse(){
        db=this.getWritableDatabase();
        String query="";
        query="UPDATE palabras set  repasado=0";
        db.execSQL(query);
        db.close();
    }

    public void guardarResultado(int id,int columna){
        db=this.getWritableDatabase();
        String query="";
        if (columna==2)
        {
             query="UPDATE palabras set equivocadas=equivocadas+1, repasado=1 where id="+id;
        }
        else{
            query="UPDATE palabras set  correctas=correctas+1, repasado=1 where id="+id;
        }
        db.execSQL(query);
        db.close();
    }

    public int getPuntuacion(){
        db=this.getReadableDatabase();
        String query = "select sum(correctas) as total from " + TABLE_PALABRAS;
        Cursor cursor = db.rawQuery(query, null);
        int puntos=0;
        if (cursor.moveToFirst()) {
             puntos = cursor.getInt(cursor.getColumnIndex("total"));
        }
        return puntos;
    }



    public String[] getPalabra() {
        db = this.getReadableDatabase();
        String query = "select id,palabra, categoria, (equivocadas-correctas) as 'Orden' from " + TABLE_PALABRAS+" where repasado=0 order by Orden desc";
        Cursor cursor = db.rawQuery(query, null);
        Random random = new Random();
        int posicion = 0;
        int posicion2, posicion3, posicion4;
        String palabra[];
        palabra = new String[6];

        cursor.moveToPosition(0);
        palabra[0] = cursor.getString(0);
        palabra[1] = cursor.getString(1);
        palabra[2] = cursor.getString(2);

        do {
            posicion2 = random.nextInt(cursor.getCount());
            posicion3 = random.nextInt(cursor.getCount());
            posicion4 = random.nextInt(cursor.getCount());
        }
        while (posicion2==posicion3||posicion2==posicion4||posicion3==posicion4||posicion==posicion2
                ||posicion==posicion3||posicion==posicion4);

        cursor.moveToPosition(posicion2);
        palabra[3] = cursor.getString(1);
        cursor.moveToPosition(posicion3);
        palabra[4] = cursor.getString(1);
        cursor.moveToPosition(posicion4);
        palabra[5] = cursor.getString(1);

        db.close();
        return palabra;
    }

    public String[] getPalabraCategoria(int categoria) {
        db = this.getReadableDatabase();
        String query = "select id,palabra, categoria, (equivocadas-correctas) as 'Orden' from " + TABLE_PALABRAS+" where categoria="+categoria+" and repasado=0";
        Cursor cursor = db.rawQuery(query, null);
        Random random = new Random();
        int posicion = 0;
        int posicion2, posicion3, posicion4;
        String palabra[];
        palabra = new String[6];

        cursor.moveToPosition(posicion);
        palabra[0] = cursor.getString(0);
        palabra[1] = cursor.getString(1);
        palabra[2] = cursor.getString(2);

        do {
            posicion2 = random.nextInt(cursor.getCount());
            posicion3 = random.nextInt(cursor.getCount());
            posicion4 = random.nextInt(cursor.getCount());
        }
        while (posicion2==posicion3||posicion2==posicion4||posicion3==posicion4||posicion==posicion2
                ||posicion==posicion3||posicion==posicion4);

        cursor.moveToPosition(posicion2);
        palabra[3] = cursor.getString(1);
        cursor.moveToPosition(posicion3);
        palabra[4] = cursor.getString(1);
        cursor.moveToPosition(posicion4);
        palabra[5] = cursor.getString(1);

        db.close();
        return palabra;
    }
}
