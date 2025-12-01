package com.example.aula2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    // Guarda o layout XML do item da lista
    int mresoucer;

    // Construtor: recebe a Activity atual, o layout do item e a lista de planetas
    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);

        // Salva o layout para usar depois no getView
        mresoucer = resource;
    }

    // Esse método cria e preenche cada item da lista
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Objeto que transforma o XML do layout em View Android
        LayoutInflater layoutInflater = LayoutInflater.from(getContext()); // inflador de layout

        // Cria a View do item da lista usando o layout salvo
        convertView = layoutInflater.inflate(mresoucer, parent, false);

        // Preencher o item da View com os dados do planeta
        TextView tvnome = convertView.findViewById(R.id.textView); // Liga ao TextView do item
        ImageView im = convertView.findViewById(R.id.imageView); // Liga ao ImageView do item

        // Pega o objeto Planeta da posição atual e preenche nome e imagem
        tvnome.setText(this.getItem(position).nome); // Mostra o nome do planeta
        im.setImageResource(this.getItem(position).imagem); // Mostra a imagem do planeta

        // Retorna o item pronto para aparecer na lista
        return convertView;
    }
}