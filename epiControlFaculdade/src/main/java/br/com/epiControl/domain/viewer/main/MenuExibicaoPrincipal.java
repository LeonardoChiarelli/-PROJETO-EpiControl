package br.com.epiControl.domain.viewer.main;

import br.com.epiControl.domain.viewer.casos.MenuAnexarCasos;
import br.com.epiControl.domain.viewer.cidadeFeito.MenuPrincipalCidade;
import br.com.epiControl.domain.viewer.doencaFeito.MenuPrincipalDoenca;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuExibicaoPrincipal extends JFrame {

    private final ServiceRegistry registry;

    public MenuExibicaoPrincipal(ServiceRegistry registry) {
        this.registry = registry;
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

        JButton botaoCidade = new JButton("Cidade");
        botaoCidade.setMaximumSize(buttonSize);
        botaoCidade.setFont(buttonFont);
        // botaoCidade.addActionListener();

        JButton botaoDoenca = new JButton("Doença");
        botaoDoenca.setMaximumSize(buttonSize);
        botaoDoenca.setFont(buttonFont);

        JButton botaoAnexarDoenca = new JButton("Anexar Casos");
        botaoAnexarDoenca.setMaximumSize(buttonSize);
        botaoAnexarDoenca.setFont(buttonFont);

        JButton botaoGerarGrafico = new JButton("Gerar Relatório");
        botaoGerarGrafico.setMaximumSize(buttonSize);
        botaoGerarGrafico.setFont(buttonFont);

        // Espaçamento entre os botões
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(botaoCidade);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoDoenca);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoAnexarDoenca);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        mainPanel.add(botaoGerarGrafico);
        mainPanel.add(Box.createVerticalGlue());

        botaoCidade.addActionListener(e -> SwingUtilities.invokeLater(() -> new MenuPrincipalCidade(registry)));

        botaoDoenca.addActionListener(e -> SwingUtilities.invokeLater(() -> new MenuPrincipalDoenca(registry)));

        // botaoAnexarDoenca.addActionListener(e -> SwingUtilities.invokeLater(() -> new MenuAnexarCasos(registry)));

        // botaoGerarGrafico.addActionListener(e -> );

        add(mainPanel);
        setVisible(true);
    }
}
