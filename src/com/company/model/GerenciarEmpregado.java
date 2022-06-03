package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class GerenciarEmpregado {
    public static List<Empregado> listaEmpregados = new ArrayList<Empregado>();

    public void adcionarEmpregado(Empregado empregado){
        listaEmpregados.add(empregado);
    }

    public ArrayList listarTodosEmpregados(){
        return (ArrayList) listaEmpregados;
    }

    public void removerEmpregado(Empregado empregado){

    }
    public boolean verificarExistencia(Empregado empregado){
        return true;
    }

    public GerenciarEmpregado(List<Empregado> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }

    public GerenciarEmpregado() {}

}
