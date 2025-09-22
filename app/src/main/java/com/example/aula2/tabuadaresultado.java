package com.example.aula2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tabuadaresultado extends AppCompatActivity {

    private TextView edResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        edResultado = findViewById(R.id.edResultado);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double tabuada = bundle.getDouble("tabuada");
            double resultado = 0;
            for (int i = 0; i <= 10; i++) {
                resultado = tabuada*i;
            }
            edResultado.setText((int) resultado);
        }
    }
}
