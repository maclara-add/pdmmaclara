package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variáveis principais
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carrega o layout da tela principal
        setContentView(R.layout.activity_main);

        // Recupera a ListView do layout XML
        lv = findViewById(R.id.listview);

        // Criamos o DAO, que é a fonte dos dados dos planetas
        PlanetaDAO planetaDao = new PlanetaDAO(); // Data Source (Origem dos dados)

        // Criamos o Adapter que vai montar a lista de planetas na tela
        PlanetaAdapter adapter = new PlanetaAdapter(this,
                R.layout.item_lista,
                planetaDao.getPlanetas());

        // Exibir a lista de planetas na ListView
        lv.setAdapter(adapter);

        // Evento de clique na lista: quando clicar em um planeta, abre a próxima tela enviando ele
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Pega o planeta clicado baseado na posição do item
                Planeta p = planetaDao.getPlanetas().get(position);

                // Criamos uma intenção para abrir a tela PlanetaController
                Intent intent = new Intent(getApplicationContext(), PlanetaController.class);

                // Coloca o planeta dentro da Intent para enviar para outra Activity
                intent.putExtra("planeta", p);

                // Inicia a nova Activity (abre a próxima tela)
                startActivity(intent);
            }
        });
    }
}