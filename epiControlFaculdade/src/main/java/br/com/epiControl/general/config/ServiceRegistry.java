package br.com.epiControl.general.config;

import br.com.epiControl.domain.service.CasosService;
import br.com.epiControl.domain.service.CidadeService;
import br.com.epiControl.domain.service.DoencaService;
import lombok.Getter;

@Getter
public class ServiceRegistry {

    private final CidadeService cidadeService;
    private final DoencaService doencaService;
    private final CasosService casosService;

    public ServiceRegistry(CidadeService cidadeService, DoencaService doencaService, CasosService casosService) {
        this.cidadeService = cidadeService;
        this.doencaService = doencaService;
        this.casosService = casosService;
    }

}
