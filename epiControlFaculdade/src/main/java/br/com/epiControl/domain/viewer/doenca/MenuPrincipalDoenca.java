package br.com.epiControl.domain.viewer.doenca;

import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

@org.springframework.stereotype.Component
public class MenuPrincipalDoenca extends JFrame {

    @Autowired
    private DoencaService service;

    public MenuPrincipalDoenca(){
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

        JButton atualizarInformacoesBtn = new JButton("Atualizar Informações");
        atualizarInformacoesBtn.setMaximumSize(buttonSize);
        atualizarInformacoesBtn.setFont(buttonFont);

        JButton removerInformacoesBtn = new JButton("Remover Informações");
        removerInformacoesBtn.setMaximumSize(buttonSize);
        removerInformacoesBtn.setFont(buttonFont);

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

        buttonPanel.add(atualizarInformacoesBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(removerInformacoesBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 20)));

        registrarDoencaBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(MenuCadastrarDoenca::new);
        });

        detalharDoencaBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(MenuDetalharDoenca::new);
        });

        atualizarInformacoesBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(MenuAdicionarInformacoesDoenca::new);
        });

        removerInformacoesBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(MenuRemoverInformacoesDoenca::new);
        });

        voltarBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(MenuExibicaoPrincipal::new);
        });

        listarDoencaBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, service.listarJOption());
        });

        return buttonPanel;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipalDoenca::new);
    }
}
