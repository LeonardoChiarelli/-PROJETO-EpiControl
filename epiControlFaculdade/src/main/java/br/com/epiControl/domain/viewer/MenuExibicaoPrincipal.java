package br.com.epiControl.domain.viewer;

import javax.swing.*;
import java.awt.*;

public class MenuExibicaoPrincipal extends JFrame {

    public MenuExibicaoPrincipal() {
        setTitle("Menu de Exibição Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal com fundo semelhante ao "antiquewhite"
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215)); // Cor "antiquewhite"
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Estilo comum para os botões
        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 16);

        JButton botaoCadastrarCidade = new JButton("Cadastrar Cidade");
        botaoCadastrarCidade.setMaximumSize(buttonSize);
        botaoCadastrarCidade.setFont(buttonFont);
        botaoCadastrarCidade.addActionListener(SwingUtilities.invokeLater(() -> {
           MenuCadastrarCidade menuCadastrar = new MenuCadastrarCidade();
           menuCadastrar.setVisible(true);
        }))

        JButton botaoCadastrarDoenca = new JButton("Cadastrar Doença");
        botaoCadastrarDoenca.setMaximumSize(buttonSize);
        botaoCadastrarDoenca.setFont(buttonFont);

        JButton botaoAnexarDoenca = new JButton("Anexar Casos");
        botaoAnexarDoenca.setMaximumSize(buttonSize);
        botaoAnexarDoenca.setFont(buttonFont);

        JButton botaoGerarGrafico = new JButton("Gerar Relatório");
        botaoGerarGrafico.setMaximumSize(buttonSize);
        botaoGerarGrafico.setFont(buttonFont);

        // Espaçamento entre os botões
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(botaoCadastrarCidade);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoCadastrarDoenca);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoAnexarDoenca);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoGerarGrafico);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuExibicaoPrincipal menu = new MenuExibicaoPrincipal();
            menu.setVisible(true);
        });
    }
}
