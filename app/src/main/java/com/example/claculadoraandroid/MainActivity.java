package com.example.claculadoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView operaciones;

    private Button ceroBoton, unoboton, dosboton, tresboton,
            cuatroboton, cincoboton, seisboton, sieteboton, ochoboton, nueveboton,
            sumarboton, restarboton, multiboton, diviboton,
            resetboton, cambioSignoboton, raizboton,
            igualboton, comaboton;

    private double res = 0, resMulDivi = 1;
    private String operador, operadorViejo;
    private ArrayList<Double> numeros = new ArrayList<>();

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

        //Numeros, capturamos el boton pulsado y le añadimos el contenido a la pantalla
        ceroBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operaciones.getText().equals("0")) {

                } else {
                    operaciones.setText(operaciones.getText() + "0");

                }
            }
        });

        unoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();

                operaciones.setText(operaciones.getText() + "1");

            }
        });
        dosboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();

                operaciones.setText(operaciones.getText() + "2");
            }
        });
        tresboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "3");
            }
        });
        cuatroboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "4");
            }
        });
        cincoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "5");
            }
        });
        seisboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "6");
            }
        });
        sieteboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "7");
            }
        });
        ochoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "8");
            }
        });
        nueveboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + "9");
            }
        });
        /**
         * Operaciones
         */
        sumarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "+";
                agregarOperador(operador);
                operaciones.setText("");
            }
        });
        restarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "-";
                agregarOperador(operador);
                operaciones.setText("");


            }
        });
        multiboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "*";
                agregarOperador(operador);
                operaciones.setText("");
            }
        });
        diviboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "/";
                agregarOperador(operador);
                operaciones.setText("");
            }
        });
        cambioSignoboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "+/-";
                agregarOperador(operador);
                igual();
            }
        });
        raizboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operador = "√";
                agregarOperador(operador);
                igual();
            }
        });
        resetboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText("0");
                numeros.clear();
                res = 0;
                resMulDivi = 1;
            }
        });
        igualboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                igual();

            }
        });
        comaboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarCero();
                operaciones.setText(operaciones.getText() + ".");
            }
        });
    }

    //Nos dara el resultado de la operacion e inicializara res a 0 y limpiara el array
    public void igual() {
        eliminarCero();
        alamacenajeValores(Double.parseDouble(operaciones.getText().toString()));
        operaciones(operador);
        operaciones.setText(String.valueOf(res));
        res = 0;
        numeros.clear();

    }

    public void alamacenajeValores(double num) {
        numeros.add(num);//alamcenamos los numeros
    }

    public void agregarOperador(String operador) {


        alamacenajeValores(Double.parseDouble(operaciones.getText().toString()));//almacenamos el contenido del textview en el array
        //Comprobamos si el operador es distinto, si es asi hara la operacion
        if ((operadorViejo != operador) && (operadorViejo != null)) {
            operaciones(operadorViejo);
            numeros.clear();
        }

        operadorViejo = operador;//guardamos el operador pulsado en la variable


    }


    public void eliminarCero() {
        if (operaciones.getText().equals("0")) {
            operaciones.setText("");
        }
    }

    public void operaciones(String operador) {

        //Dependiendo del operador seleccionado hara una operacion u otra
        switch (operador) {
            case "+":
                for (Double valores : numeros) {
                    res += valores;
                }
                break;
            case "-":
                //En la resta debemos comprobar si resultado es igual a 0 ya que de la otra forma nos saldria un resultado negativo
                //empezando a operar por la resta
                if (res == 0) {
                    res = numeros.get(0);
                    for (int i = 1; i < numeros.size(); i++) {

                        res -= numeros.get(i);
                    }
                } else {
                    for (Double valores : numeros) {
                        res -= valores;
                    }
                }
                break;
            case "*":
                if (res == 0) {
                    for (Double valores : numeros) {
                        resMulDivi *= valores;
                    }
                    res = resMulDivi;
                    resMulDivi = 1;
                } else {
                    for (Double valores : numeros) {
                        res *= valores;
                    }
                }
                break;
            case "/":
                //En la division tenemos que comprobar si el resultado esta vacio (resultado = 0),
                //si es asi el primer valor del array lo guardaremos y empezaremos a realizar la division.
                //Si no es igual a 0 haremos la division con el contenido del resultado
                //Si se divide entre 0 se activara un parpadeo con un mensaje de error.

                if (res == 0) {
                    res = numeros.get(0);

                    for (int i = 1; i < numeros.size(); i++) {

                        res /= numeros.get(i);
                    }
                    resMulDivi = 1;
                } else {
                    for (Double valores : numeros) {
                        res /= valores;
                    }
                }
                break;
            case "√":
                res = Math.sqrt(numeros.get(0));//Con este metodo nos ayuda a realizar directamente la operacion de raiz
                break;
            case "+/-":
                res = numeros.get(0) * -1;//cambiamos el numero a negativo
                break;


        }


    }


}