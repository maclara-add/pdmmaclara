package com.example.aula2;

import java.util.ArrayList;

public class PlanetaDAO {

    // Lista que vai guardar todos os planetas
    private ArrayList<Planeta> planetas;

    // Construtor: cria a lista e preenche com planetas padrão
    public PlanetaDAO() {

        this.planetas = new ArrayList<>();

        // Vetor com os nomes dos planetas
        String[] nomes = {
                "Mercurio", "Venus", "Terra", "Marte",
                "Jupter", "Saturno", "Urano", "Netuno"
        };

        // Vetor com os IDs das imagens da pasta drawable
        Integer[] imagens = {
                R.drawable.mercury, R.drawable.venus,
                R.drawable.earth, R.drawable.mars,
                R.drawable.jupter, R.drawable.saturn,
                R.drawable.uranus, R.drawable.neptune
        };

        // Loop para criar objetos planeta
        for (int i = 0; i < nomes.length; i++) {
            planetas.add(new Planeta(nomes[i], imagens[i]));
        }
    }

    // Método certo: devolve a lista de planetas
    public ArrayList<Planeta> getPlanetas() {
        return this.planetas;
    }
}