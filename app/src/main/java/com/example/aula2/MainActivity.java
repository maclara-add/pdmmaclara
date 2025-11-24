package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText edPeso, edAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Ativar o modo EdgeToEdge para a Activity
        setContentView(R.layout.activity_main);

        // Inicializando os componentes da tela
        button = findViewById(R.id.button);
        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);

        // Configurar o botão para passar os dados para a imcresultado
        button.setOnClickListener(v -> {
            // Pegar os dados inseridos
            Double peso = Double.parseDouble(edPeso.getText().toString());
            Double altura = Double.parseDouble(edAltura.getText().toString());

            // Criar a Intent para ir à ResultActivity (imcresultado)
            Intent intent = new Intent(MainActivity.this, imcresultado.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("peso", peso);
            bundle.putDouble("altura", altura);
            intent.putExtras(bundle); // Passar os dados através do Bundle

            startActivity(intent); // Iniciar a nova Activity
        });

        // Configuração dos Insets para ajustar ao sistema de barras
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
