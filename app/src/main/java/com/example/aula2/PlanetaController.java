package com.example.aula2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlanetaController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ativa o modo EdgeToEdge (conteúdo ocupa a tela toda)
        EdgeToEdge.enable(this);

        // Carrega o layout da tela de detalhes do planeta
        setContentView(R.layout.activity_planeta);

        // Recupera os dados que vieram da Intent (extras)
        Bundle bundle = getIntent().getExtras();

        // Pega o planeta enviado pela MainActivity e converte para tipo Planeta
        Planeta p = (Planeta) bundle.getSerializable("planeta"); // desserializa o objeto

        // Liga as variáveis aos componentes do layout XML
        ImageView imageView = findViewById(R.id.imageView); // Imagem do planeta
        TextView textView = findViewById(R.id.tvNomePlaneta); // Nome do planeta

        // Coloca os dados do planeta na tela
        imageView.setImageResource(p.imagem); // Mostra a imagem do drawable
        textView.setText(p.nome); // Mostra o nome do planeta
    }
}