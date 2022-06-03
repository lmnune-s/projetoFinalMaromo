package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class GerenciarEmpregado {
    public static List<Empregado> listaEmpregados = new ArrayList<Empregado>();

    public void adcionarEmpregado(Empregado empregado){
        if(verificarExistencia(empregado)){
            listaEmpregados.add(empregado);
        }else {
            System.out.println("Usuario já Cadastrado!");
        }
    }

    public ArrayList listarTodosEmpregados(){
        for (Empregado emp: listaEmpregados) {
            System.out.println(emp);
        }
        System.out.println("-------------------");
//        System.out.println(listaEmpregados);
        return (ArrayList) listaEmpregados;
    }

    public void removerEmpregado(Empregado empregado){}

    public boolean verificarExistencia(Empregado empregado){
        for (Empregado emp: listaEmpregados) {
            if(emp.getCodigoEmpregado() == (empregado.getCodigoEmpregado())){
                System.out.println("Ja cadastrado");
                return false;
            }
        }
        return true;
    }

    public GerenciarEmpregado(List<Empregado> listaEmpregados) {
        this.listaEmpregados = listaEmpregados;
    }

    public GerenciarEmpregado() {}

}
