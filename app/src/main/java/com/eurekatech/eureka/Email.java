package com.eurekatech.eureka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Email extends AppCompatActivity {
    String correo;
    TextView asunto, telefono, mensaje, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        correo = getIntent().getStringExtra("correo");
        asunto = findViewById(R.id.txtAsunto);
        telefono = findViewById(R.id.txttefono);
        mensaje = findViewById(R.id.txtMensaje);
        nombre = findViewById(R.id.txtNombre);
    }


    public void sendEmail(View v) {

        if (verificadatos()) {
            String[] TO = {correo};
            String[] CC = {""};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
           // emailIntent.setDataAndType(Uri.parse("mailto:"),"text/plain");
          // emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje.getText().toString() + "\n\n" +
                    "Atentamente: \n" + nombre.getText().toString() + "\n" + telefono.getText().toString());

            try {
                startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
                finish();
            } catch (android.content.ActivityNotFoundException ex) {

                mensaje("No tienes clientes de email instalados.");

            }

        } else {
            mensaje("Debe llenar todos los datos");
        }
    }

    boolean verificadatos() {

        return !asunto.getText().toString().equals("") && !telefono.getText().toString().equals("")
                && !mensaje.getText().toString().equals("") && !nombre.getText().toString().equals("");

    }

    private void mensaje(String mensaje) {
        Toast mensa;
        mensa = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
        mensa.setGravity(Gravity.CENTER, 0, 0);
        mensa.show();
    }

    public void salir(View v) {
        finish();
    }
}
