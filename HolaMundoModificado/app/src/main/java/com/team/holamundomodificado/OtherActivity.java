package com.team.holamundomodificado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Configuramos el layout para este activity
        setContentView(R.layout.activity_other);

        /**
         * En este caso, este activity no hace nada especial pero si quisieramos utilizarlo
         * deberiamos:
         *
         * 1 - Obtener las referencias a los componentes visuales de este activity
         * que sean de relevancia para lo que queramos hacer.
         * 2 - Implementar el comportamiento deseado para cada uno de ellos.
         */

    }
}
