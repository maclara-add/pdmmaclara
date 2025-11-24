package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText editTextNome;
    Button buttonSalvar;
    ListView listView;
    ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextText);
        buttonSalvar = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        ids = new ArrayList<>();

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS pessoas " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT)");

        carregarListagem();

        // Botão salvar
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();

                if (nome.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Digite um nome", Toast.LENGTH_SHORT).show();
                    return;
                }

                ContentValues cv = new ContentValues();
                cv.put("nome", nome);

                long status = database.insert("pessoas", null, cv);
                if (status > 0) {
                    Toast.makeText(getApplicationContext(), "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    limparCampos();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }

                carregarListagem();
            }
        });

        // Evento de clique na lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemId = ids.get(position);
                carregarDados(itemId);
            }
        });
    }

    // Carrega itens no ListView
    private void carregarListagem() {
        Cursor cursor = database.rawQuery("SELECT * FROM pessoas", null);
        ArrayList<String> nomes = new ArrayList<>();
        ids.clear();

        if (cursor.moveToFirst()) {
            do {
                nomes.add(cursor.getString(1));  // nome
                ids.add(cursor.getInt(0));      // id
            } while (cursor.moveToNext());
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, nomes
        );
        listView.setAdapter(adapter);
    }

    // Carrega item clicado na lista
    private void carregarDados(int id) {
        Cursor cursor = database.rawQuery(
                "SELECT * FROM pessoas WHERE id = ?",
                new String[]{String.valueOf(id)}
        );

        if (cursor.moveToFirst()) {
            editTextNome.setText(cursor.getString(1)); // nome
        }

        cursor.close();
    }

    private void limparCampos() {
        editTextNome.setText("");
    }
}
