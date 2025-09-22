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
        button =findViewById(R.id.button);
        editTextmax =findViewById(R.id.edMax);
        editTextmin =findViewById(R.id.edMin);
        tv =findViewById(R.id.tvResultado);
        button.setOnClickListener(v -> {
            Random random = new Random();

            int min, max;
            min = Integer.parseInt(editTextmin.getText().toString());
            max = Integer.parseInt(editTextmax.getText().toString());

            int delta = max-min;
            int sorteado = random.nextInt(delta)+min;
            tv.setText(Integer.toString(sorteado));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo_vida", "osStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo_vida", "osResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo_vida", "osPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo_vida", "osStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo_vida", "osRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo_vida", "osDestroy");
    }


}