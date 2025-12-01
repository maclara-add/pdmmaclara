package com.example.aula2;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Planeta implements Serializable {

    // Guarda o nome do planeta
    String nome;

    // Guarda o ID da imagem que está na pasta drawable (R.drawable.nome)
    Integer imagem; // São recursos da pasta drawable R.drawable.nome

    // Construtor: usado para criar um planeta com nome e imagem
    public Planeta(String nome, Integer imagem) {
        this.nome = nome; // Recebe o nome e salva na variável
        this.imagem = imagem; // Recebe o ID da imagem e salva
    }
}