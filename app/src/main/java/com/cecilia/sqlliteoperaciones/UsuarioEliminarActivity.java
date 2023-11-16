package com.cecilia.sqlliteoperaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioEliminarActivity extends AppCompatActivity {

    EditText nombreEliminar;

    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_eliminar);

        nombreEliminar = (EditText) findViewById(R.id.txtNombreEliminar);



        helper = new DbAdapter(this);


    }

    public void delete (View view){
        String datoNombre = nombreEliminar.getText().toString();

        if(datoNombre.isEmpty()){

            Mensaje.aviso(getApplicationContext(), "Introduzca los datos");

        }else{
            int resultado = helper.deleteName(datoNombre);
            if (resultado<=0){

                Mensaje.aviso(getApplicationContext(), "Eliminacion Fallida");

                nombreEliminar.setText("");




            }else{
                Mensaje.aviso(getApplicationContext(), "Eliminacion exitosa");

                nombreEliminar.setText("");

                startMainActivity();
            }
        }

    }
    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

        finish();
    }

}
