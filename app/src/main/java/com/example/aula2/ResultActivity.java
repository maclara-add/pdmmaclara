package com.example.aula2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTabuada;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_result);

        textViewTabuada = findViewById(R.id.txtTabuada);

        int numero = getIntent().getIntExtra("numero", 0);

        String resultado =
                numero + " x 1 = "  + (numero * 1)  + "\n" +
                        numero + " x 2 = "  + (numero * 2)  + "\n" +
                        numero + " x 3 = "  + (numero * 3)  + "\n" +
                        numero + " x 4 = "  + (numero * 4)  + "\n" +
                        numero + " x 5 = "  + (numero * 5)  + "\n" +
                        numero + " x 6 = "  + (numero * 6)  + "\n" +
                        numero + " x 7 = "  + (numero * 7)  + "\n" +
                        numero + " x 8 = "  + (numero * 8)  + "\n" +
                        numero + " x 9 = "  + (numero * 9)  + "\n" +
                        numero + " x 10 = " + (numero * 10);

        textViewTabuada.setText(resultado);
    }
}
