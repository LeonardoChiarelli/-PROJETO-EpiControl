package br.com.epiControl.domain.viewer.cidade;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalCidade extends JFrame {

    public MenuPrincipalCidade(){
        setTitle("Menu Principal Cidade");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal com cor de fundo semelhante ao "antiquewhite"
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215)); // antiquewhite
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento interno
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Painel interno com os botões
        JPanel buttonPanel = getJPanel();

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());
        add(mainPanel);
        setVisible(true);
    }

    private static JPanel getJPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setOpaque(false); // Transparente para manter o fundo do painel principal

        // Estilo comum para os botões
        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 16);

        // Criação dos botões
        JButton cadastrarCidadeBtn = new JButton("Cadastrar Cidade");
        cadastrarCidadeBtn.setMaximumSize(buttonSize);
        cadastrarCidadeBtn.setFont(buttonFont);

        JButton listarCidadesBtn = new JButton("Listar Cidades Cadastradas");
        listarCidadesBtn.setMaximumSize(buttonSize);
        listarCidadesBtn.setFont(buttonFont);

        JButton detalharCidadeBtn = new JButton("Detalhar Cidade");
        detalharCidadeBtn.setMaximumSize(buttonSize);
        detalharCidadeBtn.setFont(buttonFont);

        JButton voltarBtn = new JButton("Voltar");
        voltarBtn.setMaximumSize(buttonSize);
        voltarBtn.setFont(buttonFont);

        // Adiciona os botões ao painel
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(cadastrarCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(listarCidadesBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(detalharCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipalCidade::new);
    }
}
