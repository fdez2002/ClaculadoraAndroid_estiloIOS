package com.example.claculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{
    private TextView operaciones;
    private Button ceroBoton, unoboton, dosboton, tresboton,
            cuatroboton, cincoboton, seisboton, sieteboton, ochoboton, nueveboton,
                sumarboton, restarboton, multiboton, diviboton,
                    resetboton, cambioSignoboton, raizboton,
                        igualboton, comaboton;
    private double valor1, valor2, res=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operaciones = findViewById(R.id.textViewOperaciones);

        ceroBoton = findViewById(R.id.button0);
        unoboton = findViewById(R.id.button_1);
        dosboton = findViewById(R.id.button_2);
        tresboton = findViewById(R.id.button_3);
        cuatroboton = findViewById(R.id.button_4);
        cincoboton = findViewById(R.id.button_5);
        seisboton = findViewById(R.id.button_6);
        sieteboton = findViewById(R.id.button_7);
        ochoboton = findViewById(R.id.button_8);
        nueveboton = findViewById(R.id.button_9);

        sumarboton = findViewById(R.id.button_sumar);
        restarboton = findViewById(R.id.button_restar);
        multiboton = findViewById(R.id.button_multi);
        diviboton = findViewById(R.id.button_divi);

        resetboton = findViewById(R.id.button_cero);
        cambioSignoboton = findViewById(R.id.button_camSigno);
        raizboton = findViewById(R.id.button_raiz);

        igualboton = findViewById(R.id.button_igual);
        comaboton = findViewById(R.id.button_coma);

        //Numeros
        ceroBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operaciones.getText().equals("0")){

                }else{
                    operaciones.setText(operaciones.getText()+"0");

                }
            }
        });
        unoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"1");
            }
        });
        dosboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"2");
            }
        });
        tresboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"3");
            }
        });
        cuatroboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"4");
            }
        });
        cincoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"5");
            }
        });
        seisboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"6");
            }
        });
        sieteboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"7");
            }
        });
        ochoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"8");
            }
        });
        nueveboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText()+"9");
            }
        });
        //Operadores
        sumarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                sumar();
                operaciones.setText("");
                //operaciones.setText(operaciones.getText()+"+");
            }
        });
        restarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                //operaciones.setText(operaciones.getText()+"-");
            }
        });
        multiboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                //operaciones.setText(operaciones.getText()+"x");
            }
        });
        diviboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                //operaciones.setText(operaciones.getText()+"/");
            }
        });
        cambioSignoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        raizboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        resetboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText("0");
            }
        });
        igualboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                valor2 = Double.parseDouble(operaciones.getText().toString());
                res += valor2;
                //operaciones.setText("=");
                operaciones.setText(String.valueOf(res));

            }
        });
        comaboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(".");
            }
        });
    }
    public void eliminarCero(){
        if(operaciones.getText().equals("0")) {
            operaciones.setText("");
        }
    }
    public void sumar(){
        valor1 = Double.parseDouble(operaciones.getText().toString());
        res += valor1;
    }
    public void restar(){
        valor1 = Double.parseDouble(operaciones.getText().toString());
        res -= valor1;
    }


}