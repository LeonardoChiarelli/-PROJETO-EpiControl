package br.com.epiControl.domain.viewer.doencaFeito;

import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

public class MenuPrincipalDoenca extends JFrame {

    private final DoencaService service;
    private final ServiceRegistry registry;

    public MenuPrincipalDoenca(ServiceRegistry registry){
        this.registry = registry;
        this.service = registry.getDoencaService();
        setTitle("Menu Principal Doença");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPainel = new JPanel();
        mainPainel.setBackground(new Color(250, 235, 215));
        mainPainel.setLayout(new BoxLayout(mainPainel, BoxLayout.Y_AXIS));
        mainPainel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPainel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = getPainel();

        mainPainel.add(buttonPanel);
        mainPainel.add(Box.createVerticalGlue());

        add(mainPainel);
        setVisible(true);
    }

    private JPanel getPainel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setOpaque(false);

        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 16);

        JButton registrarDoencaBtn = new JButton("Cadastrar Doença");
        registrarDoencaBtn.setMaximumSize(buttonSize);
        registrarDoencaBtn.setFont(buttonFont);

        JButton listarDoencaBtn = new JButton("Listar Doenças");
        listarDoencaBtn.setMaximumSize(buttonSize);
        listarDoencaBtn.setFont(buttonFont);

        JButton detalharDoencaBtn = new JButton("Detalhar Doença");
        detalharDoencaBtn.setMaximumSize(buttonSize);
        detalharDoencaBtn.setFont(buttonFont);

        JButton voltarBtn = new JButton("Voltar");
        voltarBtn.setMaximumSize(buttonSize);
        voltarBtn.setFont(buttonFont);

        buttonPanel.add(Box.createVerticalGlue());

        buttonPanel.add(registrarDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(listarDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(detalharDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(detalharDoencaBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        registrarDoencaBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuCadastrarDoenca(registry));
            dispose();
        });

        detalharDoencaBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new MenuDetalharDoenca(registry));
            dispose();
        });

        voltarBtn.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
            dispose();
        });

        listarDoencaBtn.addActionListener(_ -> {
            String textoFinal = service.listarJOption();

            JTextArea textArea = new JTextArea(textoFinal);
            textArea.setColumns(40);
            textArea.setRows(20);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Doenças", JOptionPane.INFORMATION_MESSAGE);
        });

        return buttonPanel;

    }
}
