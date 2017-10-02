package com.team.holamundomodificado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button mChangeMessageButton, mChangeActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Configuramos un layout para nuestro activity
        setContentView(R.layout.activity_main);

        //Obtenermos las referencias de los componentes visuales desde el layout
        mTextMessage = (TextView) findViewById(R.id.message);
        mChangeMessageButton = (Button) findViewById(R.id.change_message_button);
        mChangeActivityButton = (Button) findViewById(R.id.change_activity_button);

        //Seteamos un OnClickListener para nuestro botón de cambiar mensaje
        mChangeMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Cuando el usuario haga click sobre el boton, el mensaje será cambiado
                 * dependiendo del contenido:
                 * Si dice: "Hola mundo" cambia a "Escuelas de informática" y viceversa.
                 */
                if (mTextMessage.getText().equals(getString(R.string.message)))
                    mTextMessage.setText(R.string.custom_msg);
                else
                    mTextMessage.setText(R.string.message);
            }
        });

        //De modo similar, creamos un OnClickListener para cambiar el activity
        mChangeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Cuando el usuario hace click, debemos cambiar de activity.
                 * Para eso, utilizamos un intent:
                 * El primer parámetro del constructor es una referencia al componente que crea el intent.
                 * El segundo parametro es la clase del activity o servicio que queramos invocar.
                 * Por último invocamos al metodo startActivity pasando como parámetro el intent creado.
                 */
                Intent otroActivityIntent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(otroActivityIntent);
            }
        });


    }
}
