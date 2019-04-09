package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void elguapo(View v){
        EditText Nombre=findViewById(R.id.editTextNombre);
        EditText telefono=findViewById(R.id.editText7);
        EditText cedula=findViewById(R.id.editText8);
        EditText direccion=findViewById(R.id.editText10);
        if(Nombre.length()==0){
            Nombre.setError("Debe llenar el campo");
        }
        else if (telefono.length()==0){
            telefono.setError("Debe llenar el campo");
        }
        else if (cedula.length()==0){
            cedula.setError("Debe llenar el campo");
        }
        else if (direccion.length()==0){
            direccion.setError("Debe llenar el campo");
        }
        else{
            Intent sergio=new Intent(getBaseContext(),SegundaActivity.class) ;
            startActivity(sergio);
        }

    }
}
