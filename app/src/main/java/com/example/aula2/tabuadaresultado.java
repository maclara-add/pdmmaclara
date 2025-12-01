package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class tabuadaresultado extends AppCompatActivity {

    TextView tvTab, tvResult; // Componentes que mostram o título e o resultado da tabuada
    String resultado = ""; // Variável que acumula todas as linhas da tabuada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);

        // Recupera o número enviado pela tela anterior
        Intent i = getIntent();
        Bundle b = i.getExtras();
        int num = b.getInt("num");

        tvTab = findViewById(R.id.tvTabuada);
        tvResult = findViewById(R.id.tvResultado);

        tvTab.setText("Tabuada do " + num);

        // Gera a tabuada do número recebido (0 até 10)
        for (int a = 0; a < 11; a++) {
            resultado = resultado + a + " x " + num + " = " + (a * num) + "\n";
            tvResult.setText(resultado); // Atualiza o TextView com a tabuada
        }
    }
}