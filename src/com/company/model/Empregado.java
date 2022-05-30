package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
public class Empregado {
    private int codigoEmpregado;
    private String nomeEmpregado;
    private String setor;
    private double salarioBruto;
    private double recInss;

    public Empregado() {
    }
}


