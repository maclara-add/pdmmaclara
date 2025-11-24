package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula2.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tvResultados;
    EditText edMin, edMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando as Views
        edMin = findViewById(R.id.edMin);  // Campo para o valor mínimo
        edMax = findViewById(R.id.edMax);  // Campo para o valor máximo
        tvResultados = findViewById(R.id.tvResultados); // TextView onde mostra o resultado
        button = findViewById(R.id.button); // Botão para realizar o sorteio

        // Configurando o clique do botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tenta obter os valores inseridos
                String minText = edMin.getText().toString();
                String maxText = edMax.getText().toString();

                // Verificar se os campos não estão vazios
                if (minText.isEmpty() || maxText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha os dois intervalos.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Converter os valores dos campos EditText para inteiros
                int minValue = Integer.parseInt(minText);
                int maxValue = Integer.parseInt(maxText);

                // Validar se o valor mínimo é menor que o valor máximo
                if (minValue >= maxValue) {
                    Toast.makeText(MainActivity.this, "O valor mínimo deve ser menor que o máximo.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Sorteio de número aleatório dentro do intervalo
                Random random = new Random();
                int sorteado = random.nextInt(maxValue - minValue + 1) + minValue; // Garante que o número esteja entre minValue e maxValue

                // Mostrar o número sorteado no TextView
                tvResultados.setText(String.valueOf(sorteado));
            }
        });
    }
}
