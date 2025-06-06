package br.com.epiControl.domain.viewer.cidadeFeito;

import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalCidade extends JFrame {

    private final ServiceRegistry registry;
    private final CidadeService service;

    public MenuPrincipalCidade(ServiceRegistry registry){
        this.registry = registry;
        this.service = registry.getCidadeService();
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

    private JPanel getJPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setOpaque(false); // Transparente para manter o fundo do painel principal

        // Estilo comum para os botões
        Dimension buttonSize = new Dimension(250, 40);
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

        JButton atualizarInfoCidadeBtn = new JButton("Atualizar Informações");
        atualizarInfoCidadeBtn.setMaximumSize(buttonSize);
        atualizarInfoCidadeBtn.setFont(buttonFont);

        // Adiciona os botões ao painel
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(cadastrarCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(listarCidadesBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(detalharCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(atualizarInfoCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        cadastrarCidadeBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuCadastrarCidade(registry));
            dispose();
        });

        listarCidadesBtn.addActionListener(e -> {
            String textoFinal = service.listarJOption();

            JTextArea textArea = new JTextArea(textoFinal);
            textArea.setColumns(40);
            textArea.setRows(20);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Cidades", JOptionPane.INFORMATION_MESSAGE);
        });

        detalharCidadeBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuDetalharCidade(registry));
            dispose();
        });

        voltarBtn.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
            dispose();
        });

        atualizarInfoCidadeBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuAtualizarInformacoesCidade(registry));
            dispose();
        });
        return buttonPanel;
    }
}
