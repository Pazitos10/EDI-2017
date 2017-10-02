package com.team.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //El IDE configura el layout para nuestro Activity
        setContentView(R.layout.activity_main);
    }
}
