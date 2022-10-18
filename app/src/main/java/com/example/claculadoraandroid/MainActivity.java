package com.example.claculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView operaciones;
    private Button ceroBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operaciones = findViewById(R.id.textViewOperaciones);
        ceroBoton = findViewById(R.id.button0);





    }
    private void numeroPresionado(String digito){

        operaciones.setText(digito);
    }


}