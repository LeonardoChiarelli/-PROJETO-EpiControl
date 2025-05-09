package br.com.epiControl.domain.viewer.casos;

import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;

public class MenuAnexarCasos extends JFrame {

    private final ServiceRegistry registry;
    private final CasosService service;

    public MenuAnexarCasos(ServiceRegistry registry){
        this.registry = registry;
        this.service = registry.getCasosService();

        setTitle("Menu Principal Anexar Casos");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(250, 235, 215));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = getPanel();

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);
        setVisible(true);
    }

    private JPanel getPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setOpaque(false);

        Dimension buttonSize = new Dimension(250, 40);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 16);

        JButton listarCasosPorCidadeBtn = new JButton("Listar Casos Por Cidade");
        listarCasosPorCidadeBtn.setMaximumSize(buttonSize);
        listarCasosPorCidadeBtn.setFont(buttonFont);

        JButton listarCasosPorDoencaBtn = new JButton("Listar Casos Por Doença");
        listarCasosPorDoencaBtn.setMaximumSize(buttonSize);
        listarCasosPorDoencaBtn.setFont(buttonFont);

        JButton listarCasosPorCidadeEDoencaBtn = new JButton("Listar Casos Por Cidade e Doença");
        listarCasosPorCidadeEDoencaBtn.setMaximumSize(buttonSize);
        listarCasosPorCidadeEDoencaBtn.setFont(buttonFont);

        JButton detalharCasosBtn = new JButton("Detalhar Casos");
        detalharCasosBtn.setMaximumSize(buttonSize);
        detalharCasosBtn.setFont(buttonFont);

        JButton atualizarDadosBtn = new JButton("Atualizar Informações");
        atualizarDadosBtn.setMaximumSize(buttonSize);
        atualizarDadosBtn.setFont(buttonFont);

        JButton voltarBtn = new JButton("Voltar");
        voltarBtn.setMaximumSize(buttonSize);
        voltarBtn.setFont(buttonFont);

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(listarCasosPorCidadeBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(listarCasosPorDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(listarCasosPorCidadeEDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(detalharCasosBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(atualizarDadosBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        listarCasosPorCidadeBtn.addActionListener(e -> {
            String textoFinal = service.listarCasosPorCidadeJOption();

            JTextArea textArea = new JTextArea(textoFinal);
            textArea.setColumns(40);
            textArea.setRows(20);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Casos Por Cidade", JOptionPane.INFORMATION_MESSAGE);
        });

        listarCasosPorDoencaBtn.addActionListener(e -> {
            String textoFinal = service.listarCasosPorDoencaJOption();

            JTextArea textArea = new JTextArea(textoFinal);
            textArea.setColumns(40);
            textArea.setRows(20);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Casos Por Doença", JOptionPane.INFORMATION_MESSAGE);
        });

        listarCasosPorCidadeEDoencaBtn.addActionListener(e -> {
            String textoFinal = service.listarCasosPorCidadeEDoencaJOption();

            JTextArea textArea = new JTextArea(textoFinal);
            textArea.setColumns(40);
            textArea.setRows(20);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Casos Por Cidade e Doença", JOptionPane.INFORMATION_MESSAGE);
        });

        detalharCasosBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuDetalharCasos(registry));
            dispose();
        });

        atualizarDadosBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuAtualizarDadosCasos(registry));
            dispose();
        });

        voltarBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
            dispose();
        });

        return buttonPanel;
    }
}
