package com.example.aula2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextmin, editTextmax;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d("Ciclo_vida", "onCreate");

        button = findViewById(R.id.button);
        editTextmax = findViewById(R.id.edMax);
        editTextmin = findViewById(R.id.edMin);
        tv = findViewById(R.id.tvResultado);

        button.setOnClickListener(v -> {
            String minStr = editTextmin.getText().toString();
            String maxStr = editTextmax.getText().toString();

            // Verifica se os campos estão vazios
            if (minStr.isEmpty() || maxStr.isEmpty()) {
                tv.setText("Digite os dois números!");
                return;
            }

            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            // Verifica se min é maior que max
            if (min > max) {
                tv.setText("O mínimo não pode ser maior que o máximo!");
                return;
            }

            Random random = new Random();
            int delta = max - min + 1; // +1 para incluir o máximo
            int sorteado = random.nextInt(delta) + min;

            tv.setText("Número sorteado: " + sorteado);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo_vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo_vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo_vida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo_vida", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo_vida", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo_vida", "onDestroy");
    }
}
