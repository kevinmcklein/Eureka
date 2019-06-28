package com.eurekatech.eureka;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView texto;
    String llamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void llamar(View v){

        int id=v.getId();

        switch (id){

            case R.id.btnPhones1:
            case R.id.txtPhones1:
                 texto=findViewById(R.id.txtPhones1);
                llamada=texto.getText().toString();
                HacerLLamada(llamada);
                break;

            case R.id.btnPhones2:
            case R.id.txtPhones2:
                texto=findViewById(R.id.txtPhones2);
                 llamada=texto.getText().toString();
                HacerLLamada(llamada);
                break;

            case R.id.btnEmail1:
            case R.id.txtEmail1:
                texto=findViewById(R.id.txtEmail1);
                llamada=texto.getText().toString();
                EnviarCorreo(llamada);
                break;

            case R.id.btnEmail2:
            case R.id.txtEmail2:
                texto=findViewById(R.id.txtEmail2);
                llamada=texto.getText().toString();
                EnviarCorreo(llamada);
                break;



        }




    }

    private void HacerLLamada(String Telefono){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+Telefono));
        startActivity(intent);
    }

   private void EnviarCorreo(String correo){
       Intent i = new Intent (this, Email.class);
       i.putExtra("correo", correo);

       startActivity(i);

   }
}
