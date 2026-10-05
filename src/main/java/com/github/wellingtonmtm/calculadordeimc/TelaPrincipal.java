/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.wellingtonmtm.calculadordeimc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author T-GAMER
 */
public class TelaPrincipal {

    public void abrirTela() {
        SwingUtilities.invokeLater(() -> {
            JFrame tela = new JFrame("Calculador de IMC");
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
            
            // Implementar um DocumentFilter para impedir o uso de letras
            JPanel panelAltura = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel txtAltura = new JLabel("Digite sua altura: ");
            txtAltura.setToolTipText("Valores aceito: 'm','cm'");
            JTextField areaAltura = new JTextField(10);

            panelAltura.add(txtAltura);
            panelAltura.add(areaAltura);
            
            contentPane.add(Box.createVerticalStrut(20));
            contentPane.add(panelAltura);
            
            JPanel panelPeso = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JLabel txtPeso = new JLabel("Digite seu peso: ");
            txtPeso.setToolTipText("Valor aceito: 'kg'");
            JTextField areaPeso = new JTextField(10);

            panelPeso.add(txtPeso);
            panelPeso.add(areaPeso);
            
            contentPane.add(Box.createVerticalStrut(20));
            contentPane.add(panelPeso);
            
            JPanel botao = new JPanel (new FlowLayout(FlowLayout.CENTER));
            
            JButton calcular = new JButton("Calcular");
            
            botao.add(calcular);

            calcular.addActionListener(e -> {
                try {
                String altura = areaAltura.getText();
                String peso = areaPeso.getText();

                abrirDialogo(tela, altura, peso);
                } catch (Exception error) {
                    abrirErro(tela);
                }
            });

            contentPane.add(Box.createVerticalStrut(10));
            contentPane.add(botao);
            
            tela.add(contentPane);
            tela.pack();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });

    }

    public void abrirDialogo(JFrame tela, String altura, String peso) {
        JDialog dialogoPesos = new JDialog(tela, "Informações sobre seu IMC", true);
        dialogoPesos.setSize(400, 100);
        dialogoPesos.setLocationRelativeTo(tela);

        double alturaConvertida;

        if (altura.lastIndexOf(".") <= 1 && altura.lastIndexOf(".") > 0) {
            alturaConvertida = Double.parseDouble(altura);
        } else {
            alturaConvertida = Double.parseDouble(altura) / 100;
        }

        double pesoConvertido = Double.parseDouble(peso);

        double imc = Math.round((pesoConvertido) / Math.pow(alturaConvertida, 2) * 100.0) / 100.0;
        
        JPanel info = new JPanel();
        
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        
        JLabel resultadoIMC = new JLabel("Seu IMC é de: " + imc);
        JLabel statusIMC = new JLabel("");
        
        if (imc < 18.5) {
            statusIMC.setForeground(Color.red);
            statusIMC.setFont(new Font("Arial", Font.PLAIN, 14));
            statusIMC.setText("Você está abaixo do seu peso ideal.");
        } else if (imc < 25) {
            statusIMC.setForeground(Color.green);
            statusIMC.setFont(new Font("Arial", Font.PLAIN, 14));
            statusIMC.setText("Parabéns! Você está no seu peso ideal.");
        } else if (imc < 30) {
            statusIMC.setText("Você está acima do peso (Sobrepeso).");
            statusIMC.setForeground(Color.orange);
            statusIMC.setFont(new Font("Arial", Font.PLAIN, 14));
        } else if (imc < 35) {
            statusIMC.setForeground(Color.red);
            statusIMC.setFont(new Font("Arial", Font.BOLD, 14));
            statusIMC.setText("Você está em Obesidade Grau I.");
        } else if (imc < 40) {
            statusIMC.setForeground(Color.red);
            statusIMC.setFont(new Font("Arial", Font.BOLD, 16));
            statusIMC.setText("Você está em Obesidade Grau II.");
        } else {
            statusIMC.setForeground(Color.red);
            statusIMC.setFont(new Font("Arial", Font.BOLD, 18));
            statusIMC.setText("Você está em Obesidade Grau III.");
        }
        resultadoIMC.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusIMC.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(resultadoIMC);
        info.add(statusIMC);        
        dialogoPesos.add(info);

        dialogoPesos.setVisible(true);
    }
    
    public void abrirErro(JFrame tela) {
        JDialog erroMensagem = new JDialog(tela,"Valor inválido",true);
        erroMensagem.setSize(400, 100);
        erroMensagem.setLocationRelativeTo(tela);
        
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        JLabel mensagem = new JLabel("Valor inválido. Por favor cheque novamente as informações.");
        
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        info.add(mensagem);
        erroMensagem.add(info);
        
        erroMensagem.setVisible(true);
    }
}
