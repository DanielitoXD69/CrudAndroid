package com.example.mycrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spSpinner;
    String[] comunas = new String[]{"Puente alto","Peñalolen","Santiago Centro","El Bosque","Quilicura"};
    EditText edtRut, edtNombre, edtDireccion;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //conexion
        edtRut = (EditText) findViewById(R.id.edtRut);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        spSpinner = (Spinner) findViewById(R.id.spSpinner);
        lista = (ListView) findViewById(R.id.lstLista);
        //Poblar Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>
                (this , android.R.layout.simple_spinner_item,comunas);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(spinnerAdapter);
    }
    public void onClickAgregar(View view){
        DataHelper dh = new DataHelper(this , "alumno.db ", null ,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("rut" ,edtRut.getText().toString());
        reg.put("nom" ,edtNombre.getText().toString());
        reg.put("dir" ,edtDireccion.getText().toString());
        reg.put("com" ,spSpinner.getSelectedItem().toString());
        long resp = bd.insert("alumno", null, reg);
        bd.close();
        if (resp == -1){
            Toast.makeText(this, "No se pudo agregar correctamente", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "Registro agregado con exito", Toast.LENGTH_LONG).show();
        }
        CargarLista;
    }
}