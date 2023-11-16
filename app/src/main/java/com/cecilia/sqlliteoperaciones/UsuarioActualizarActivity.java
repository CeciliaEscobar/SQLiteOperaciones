package com.cecilia.sqlliteoperaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UsuarioActualizarActivity extends AppCompatActivity {
    EditText nombreActual, nombreNuevo;

    DbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_actualizar);

        nombreActual = (EditText) findViewById(R.id.txtNombreActual);
        nombreNuevo = (EditText) findViewById(R.id.txtNombreNuevo);

        helper = new DbAdapter(this);


    }

    public void update(View view) {

        String datoNombreActual = nombreActual.getText().toString();
        String datoNombreNuevo = nombreNuevo.getText().toString();

        if (datoNombreActual.isEmpty() || datoNombreNuevo.isEmpty()) {

            Mensaje.aviso(getApplicationContext(), "Introduzca los datos");

        }else{
        int resultado = helper.updateName(datoNombreActual, datoNombreNuevo);
        if (resultado <= 0) {

            Mensaje.aviso(getApplicationContext(), "Actualizacion Fallida");

            nombreActual.setText("");

            nombreNuevo.setText("");


        } else {
            Mensaje.aviso(getApplicationContext(), "Actualizacion exitosa");
            nombreActual.setText("");

            nombreNuevo.setText("");

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
