package br.com.epiControl;

import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import br.com.epiControl.domain.viewer.main.MenuExibicaoPrincipal;
import br.com.epiControl.general.config.ServiceRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class EpiControlApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");

		ApplicationContext context = SpringApplication.run(EpiControlApplication.class, args);

		ServiceRegistry registry = new ServiceRegistry(
				context.getBean(CidadeService.class),
				context.getBean(DoencaService.class),
				context.getBean(CasosService.class)
		);

		SwingUtilities.invokeLater(() -> new MenuExibicaoPrincipal(registry));
	}
}
