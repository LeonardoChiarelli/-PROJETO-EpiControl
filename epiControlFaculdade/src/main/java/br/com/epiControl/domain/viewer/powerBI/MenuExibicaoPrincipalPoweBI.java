package br.com.epiControl.domain.viewer.powerBI;

import br.com.epiControl.EpiControlApplication;
import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class MenuExibicaoPrincipalPoweBI extends JFrame {

    private String url;
    private final ServiceRegistry registry;

    public MenuExibicaoPrincipalPoweBI(ServiceRegistry registry){
        this.registry = registry;
        setTitle("Menu de Exibição Views");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 235, 215));
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

        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 16);

        JButton graficoGeralBtn = new JButton("Gráfico Geral");
        graficoGeralBtn.setMaximumSize(buttonSize);
        graficoGeralBtn.setFont(buttonFont);

        JButton graficoPorCidadeBtn = new JButton("Gráfico por Cidades");
        graficoGeralBtn.setMaximumSize(buttonSize);
        graficoGeralBtn.setFont(buttonFont);

        JButton graficoPorDoencaBtn = new JButton("Gráfico por Doenças");
        graficoGeralBtn.setMaximumSize(buttonSize);
        graficoGeralBtn.setFont(buttonFont);

        JButton graficoPorMesBtn = new JButton("Gráfico por Meses");
        graficoGeralBtn.setMaximumSize(buttonSize);
        graficoGeralBtn.setFont(buttonFont);

        JButton graficoPorStausBtn = new JButton("Gráfico por Status");
        graficoGeralBtn.setMaximumSize(buttonSize);
        graficoGeralBtn.setFont(buttonFont);

        JButton voltarBtn = new JButton("Voltar");
        voltarBtn.setMaximumSize(buttonSize);
        voltarBtn.setFont(buttonFont);

        buttonPanel.add(Box.createVerticalGlue());

        Dimension buttonPanelDimension = new Dimension(10, 20);

        buttonPanel.add(graficoGeralBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        buttonPanel.add(graficoPorCidadeBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        buttonPanel.add(graficoPorDoencaBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        buttonPanel.add(graficoPorMesBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        buttonPanel.add(graficoPorStausBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        buttonPanel.add(voltarBtn);
        buttonPanel.add(Box.createRigidArea(buttonPanelDimension));

        graficoGeralBtn.addActionListener(e -> {
            try{
                url = "";

                Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao abrir o gráfico online: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        graficoPorCidadeBtn.addActionListener(e -> {
            try{
                url = "";

                Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao abrir o gráfico online: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        graficoPorDoencaBtn.addActionListener(e -> {
            try{
                url = "";

                Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao abrir o gráfico online: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        graficoPorMesBtn.addActionListener(e -> {
            try{
                url = "";

                Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao abrir o gráfico online: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        graficoPorStausBtn.addActionListener(e -> {
            try{
                url = "";

                Desktop.getDesktop().browse(new java.net.URI(url));
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao abrir o gráfico online: " + ex.getMessage(),
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        voltarBtn.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
            dispose();
        });

        return buttonPanel;
    }
}
