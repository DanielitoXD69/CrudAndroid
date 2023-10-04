package com.example.mycrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;



//desde la linea siguiente debe de estar si o si para crear una base de datos funcional

public class DataHelper extends SQLiteOpenHelper {

    public DataHelper(@Nullable Context context,
                      @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory,
                      int version){
        super(context, name, factory, version);
    }

    //el oncreate sirve para crear la base de datso
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE alumno (rut INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT)");
    }
    //se hace un onupgrade para eliminar version antigua y colocar una version nueva por el gran hecho de que se generan errores
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS alumno" );
        db.execSQL("CREATE TABLE alumno (rut INTEGER PRIMARY KEY, nom TEXT, dir TEXT, com TEXT)");
    }
}

