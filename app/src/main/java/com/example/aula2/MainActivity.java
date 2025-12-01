package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Variáveis principais
    int num; // Guarda o número digitado para enviar para a SegundaTela
    EditText etNum; // Campo do layout onde o usuário digita o número
    Button button; // Botão que será clicado para executar a ação

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Ativa o modo que adapta o layout às bordas da tela
        setContentView(R.layout.activity_main); // Carrega o layout da tela principal

        // Recupera o EditText do XML e liga na variável etNum
        etNum = findViewById(R.id.etNum);

        // Recupera o botão do layout e liga na variável button
        button = findViewById(R.id.button);

        // Define a lógica que vai acontecer quando o botão for clicado
        button.setOnClickListener(v -> {

            // Criamos a intenção para abrir a segunda tela
            Intent intent = new Intent(this, tabuadaresultado.class);

            // Pegamos o texto digitado, convertemos para String e depois para inteiro
            num = Integer.parseInt(etNum.getText().toString());

            // Criamos um Bundle (container de dados para mandar entre telas)
            Bundle b = new Bundle();

            // Colocamos o número dentro do Bundle usando a chave "num"
            b.putInt("num", num);

            // Anexamos o Bundle na intenção
            intent.putExtras(b);

            // Inicia a troca de tela abrindo a SegundaTela
            startActivity(intent);
        });
    }
}