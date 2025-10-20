package com.example.aula2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button bEntrar;

    EditText editText;
    ArrayList<String> nomes ;
    PlanetaController planetaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        bEntrar = findViewById(R.id.bottEntrar);
        editText = findViewById(R.id.editTextText);
        planetaController = new PlanetaController();
        PlanetaAdapter adapter = new PlanetaAdapter(this,
                R.layout.item_lista,
                planetaController.getPlaneta());
        listView.setAdapter(adapter);


        bEntrar.setOnClickListener(( view) -> {
            nomes.add(editText.getText().toString());
            adapter.notifyDataSetChanged();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            nomes.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });

    }
}