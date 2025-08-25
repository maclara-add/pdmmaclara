package com.example.aula2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo_vida", "OnStart");
        Log.wtf("Ciclo_vida", "OnStart");;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ciclo_vida", "OnRestart");
        Log.wtf("Ciclo_vida", "OnRestart");;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo_vida", "OnResume");
        Log.wtf("Ciclo_vida", "OnResume");;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo_vida", "OnPause");
        Log.wtf("Ciclo_vida", "OnPause");;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ciclo_vida", "OnStop");
        Log.wtf("Ciclo_vida", "OnStop");;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ciclo_vida", "OnDestroy");
        Log.wtf("Ciclo_vida", "OnDestroy");;

    }

}