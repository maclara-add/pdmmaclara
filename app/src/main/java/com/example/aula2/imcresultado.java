package com.example.aula2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class imcresultado extends AppCompatActivity {

    private TextView resultTextView;
    private TextView classificationTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Ativar o modo EdgeToEdge para usar barras de sistema
        setContentView(R.layout.activity_imcresultado);

        // Configurar a aplicação dos Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Definir o padding para ajustar ao sistema
            return insets;
        });

        // Inicializar os componentes da tela
        resultTextView = findViewById(R.id.resultTextView);
        classificationTextView = findViewById(R.id.classificationTextView);
        backButton = findViewById(R.id.backButton);

        // Obter os dados passados pela MainActivity
        double peso = getIntent().getDoubleExtra("peso", 0);
        double altura = getIntent().getDoubleExtra("altura", 0);

        // Calcular o IMC
        double imc = calcularIMC(peso, altura);

        // Exibir o IMC e a classificação
        resultTextView.setText(String.format("IMC: %.2f", imc));
        classificationTextView.setText(getClassification(imc));

        // Definir a ação do botão de voltar
        backButton.setOnClickListener(v -> finish()); // Voltar à tela anterior
    }

    // Método para calcular o IMC
    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método para determinar a classificação com base no IMC
    private String getClassification(double imc) {
        if (imc < 18.5) {
            return "Classificação: Abaixo do peso";
        } else if (imc < 24.9) {
            return "Classificação: Peso normal";
        } else if (imc < 29.9) {
            return "Classificação: Sobrepeso";
        } else if (imc < 34.9) {
            return "Classificação: Obesidade grau 1";
        } else if (imc < 39.9) {
            return "Classificação: Obesidade grau 2";
        } else {
            return "Classificação: Obesidade grau 3";
        }
    }
}
