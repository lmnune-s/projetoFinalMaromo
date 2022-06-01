package com.company.view;

import com.company.model.Empregado;
import com.company.model.GerenciarEmpregado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GerenciarEmpregadosGUI {
    private JPanel panelEmpregados;
    private JTable table1;
    public List<Empregado> listaEmpregados;

    GerenciarEmpregado ge = new GerenciarEmpregado();

//    public void empregadoLista(){
//        for (Empregado emp: listaEmpregados) {
//
//        }
//    }


    public GerenciarEmpregadosGUI() {
//        criarTabela();
    }

    String header[] = {"Codigo", "Nome", "Setor", "Salario Bruto", "Recolhimento"};

    private void createUIComponents(){
        DefaultTableModel model = new DefaultTableModel(0,4);
        model.setColumnIdentifiers(header);
        table1 = new JTable(model);
        List<Empregado> empregados = ge.listarTodosEmpregados();
        for (Empregado emp: empregados) {
            Object[] row = {emp.getCodigoEmpregado(), emp.getNomeEmpregado(), emp.getSetor(),
                    emp.getSalarioBruto(), emp.getRecInss()
            };
            model.addRow(row);
        }
    }


    public void criarTabela(){
//        table1.setModel(new DefaultTableModel(
//                null,
//                header
//        ));
    }

    public JPanel getPanelEmpregados() {
        return panelEmpregados;
    }

}
