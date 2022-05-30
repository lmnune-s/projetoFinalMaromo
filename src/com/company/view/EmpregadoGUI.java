package com.company.view;

import com.company.model.Empregado;
import com.company.model.GerenciarEmpregado;
import com.company.model.ParametrosInss;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpregadoGUI {
    private JTextField textFieldNomeEmpregado;
    private JTextField textFieldCodigoEmpregado;
    private JTextField textFieldSetor;
    private JTextField textFieldSalarioBruto;
    private JButton calcularRecolhimentoINSSButton;
    private JButton cadastrarButton;
    private JButton apresentarEmpregadosButton;
    private JLabel LabelCodigoEmpregado;
    private JLabel LabelNomeEmpregado;
    private JLabel LabelSetor;
    private JLabel LabelSalarioBruto;
    private JLabel LabelRecolhimento;
    private JLabel LabelReais;
    private JLabel LabelValorRecolhido;
    private JPanel JPanelTelaCadastro;

    public Empregado empregado;
    public GerenciarEmpregado ge;
    public ParametrosInss inss;

    public JPanel getPanelTelaCadastro(){
        return JPanelTelaCadastro;
    }

    public EmpregadoGUI(){
        apresentarEmpregadosButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirGrupoEmpregados();
            }
        });
        calcularRecolhimentoINSSButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                textFieldCodigoEmpregado.setText(String.valueOf(1));
//                textFieldNomeEmpregado.setText("Nome do caboclo");
//                textFieldSetor.setText("Logistica");
//                textFieldSalarioBruto.setText(String.valueOf(1500));
                CalcularRecolhimentoInss();
            }
        });
        cadastrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               adicionarEmpregado();
            }
        });
    }

    public void CalcularRecolhimentoInss() {
        try{
            empregado = new Empregado();
            inss = new ParametrosInss();
            Integer codigo = Integer.parseInt(textFieldCodigoEmpregado.getText());
            String nome = textFieldNomeEmpregado.getText();
            String setor = textFieldSetor.getText();
            Double salarioBruto = Double.parseDouble(textFieldSalarioBruto.getText());
            empregado.setCodigoEmpregado(codigo);
            empregado.setNomeEmpregado(nome);
            empregado.setSetor(setor);
            empregado.setSalarioBruto(salarioBruto);
            empregado.setRecInss(calcularRecolhimento(salarioBruto));

            LabelValorRecolhido.setText(String.valueOf(empregado.getRecInss()));


        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void validaButton(){
        JOptionPane.showMessageDialog(null,
                "Depósito efetuado com sucesso",
                "Depósito - Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public double calcularRecolhimento(double salarioBruto){
        double recolhimento = 0.0;

        // LIMITE FAIXA 1
        if (salarioBruto <= inss.LIMITEFAIXA1){
            return recolhimento = salarioBruto * inss.FAIXA1;
        }

        // LIMITE FAIXA 2
        if (salarioBruto <= inss.LIMITEFAIXA2){
            recolhimento += inss.LIMITEFAIXA1* inss.FAIXA1;
            return recolhimento += (salarioBruto - inss.LIMITEFAIXA1) * inss.FAIXA2;
        }

        // LIMITE FAIXA 3
        if (salarioBruto <= inss.LIMITEFAIXA3){
            recolhimento += inss.LIMITEFAIXA1* inss.FAIXA1;
            recolhimento += (inss.LIMITEFAIXA2-inss.LIMITEFAIXA1) * inss.FAIXA2;
            return recolhimento += (salarioBruto - inss.LIMITEFAIXA2) * inss.FAIXA3;
        }

        //LIMITE FAIXA 4
        if (salarioBruto <= inss.LIMITEFAIXA4){
            recolhimento += inss.LIMITEFAIXA1* inss.FAIXA1;
            recolhimento += (inss.LIMITEFAIXA2-inss.LIMITEFAIXA1) * inss.FAIXA2;
            recolhimento += (inss.LIMITEFAIXA3-inss.LIMITEFAIXA2) * inss.FAIXA3;
            return recolhimento += (salarioBruto- inss.LIMITEFAIXA3) * inss.FAIXA4;
        }

        recolhimento += inss.LIMITEFAIXA1* inss.FAIXA1;
        recolhimento += (inss.LIMITEFAIXA2-inss.LIMITEFAIXA1) * inss.FAIXA2;
        recolhimento += (inss.LIMITEFAIXA3-inss.LIMITEFAIXA2) * inss.FAIXA3;
        recolhimento += (inss.LIMITEFAIXA4-inss.LIMITEFAIXA3) * inss.FAIXA4;
        return recolhimento;
    }
    public void abrirGrupoEmpregados(){
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarEmpregado(){
        ge = new GerenciarEmpregado();
        ge.adcionarEmpregado(empregado);
        System.out.println(ge.listarTodosEmpregados());

    }
}
