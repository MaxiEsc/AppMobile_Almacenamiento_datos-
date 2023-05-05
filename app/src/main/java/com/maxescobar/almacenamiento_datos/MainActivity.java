package com.maxescobar.almacenamiento_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail = (EditText) findViewById(R.id.etMail);
        //Linea indispensable para la recuperacion de lo guardado
        SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        //Coloca lo que encuentra en el edit text con el Key mail
        etMail.setText(sp.getString("mail",""));


    }

    //Metodo para Guardar el mail
    public void btnGuardar(View vista){
        //Permite crear un punto que permite la restauracion de alguna cosa.
        SharedPreferences sp = getSharedPreferences("data",Context.MODE_PRIVATE);
        //Nos permite editar el objeto sp que es de tipo SharedPreferences
        SharedPreferences.Editor spEditor = sp.edit();
        //Con esto le decimos al objeto que guarde con la clave mail el texto del EditText
        spEditor.putString("mail",etMail.getText().toString());
        //Guardaos con commit como en la base de datos
        spEditor.commit();
        //Mensaje para que sepa que demonios esta pasando
        Toast.makeText(this,"Mail Guardado",Toast.LENGTH_LONG).show();
        //Finaliza la aplicacion de una vez como en el ejercicio anterior
        finish();
    }
}