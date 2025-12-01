package com.example.aula2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula2.R;

public class MainActivity extends AppCompatActivity {
    String[] nomes = new String[] {
            "Maria Clara", "Naju", "Natan",
            "Sarah", "Clarocas"
    };

    ListView lv; // os nomes q vao aparecer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recupera a list view na lv
        lv = findViewById(R.id.listview);

        // conecta os nomes do layout a cada item
        ArrayAdapter<String> a = new ArrayAdapter(
                this,
                R.layout.item_lista,
                R.id.textView,
                nomes // vetor nomes
        );

        // p exibir o nome
        lv.setAdapter(a);
    }
}