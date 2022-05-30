package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class GerenciarEmpregado {
    public List<Empregado> listaEmpregados;

    public void adcionarEmpregado(Empregado empregado){
        listaEmpregados = new ArrayList<Empregado>();
        listaEmpregados.add(empregado);
    }

    public List<Empregado> listarTodosEmpregados(){
        return listaEmpregados;
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
