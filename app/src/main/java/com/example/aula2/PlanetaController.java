package com.example.aula2;

import java.util.ArrayList;

public class PlanetaController {

    PlanetaDAO planetaDao;

    public PlanetaController(){
        planetaDao = new PlanetaDAO();
    }

    public void addPlaneta(Planeta planeta){
    }

    public ArrayList<Planeta> getPlaneta(){
        return planetaDao.getPlanetas();
    }

    public ArrayList<String> getNomePlaneta(){
        ArrayList<String> nomes = new ArrayList<String>();
        for(Planeta planeta : planetaDao.getPlanetas()){
            nomes.add(planeta.nome);
        }
        return nomes;
    }
}
