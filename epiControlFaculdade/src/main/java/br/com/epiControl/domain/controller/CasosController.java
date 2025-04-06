package br.com.epiControl.domain.controller;

import br.com.epiControl.domain.dto.AnexarCasosDTO;
import br.com.epiControl.domain.dto.DetalhesCasosDTO;
import br.com.epiControl.domain.service.CasosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/epiControl/casos")
public class CasosController {

    @Autowired
    private CasosService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCasosDTO> anexarCasos(@RequestBody @Valid AnexarCasosDTO dto, UriComponentsBuilder uriBuilder){
        var casos = service.anexar(dto);

        var uri = uriBuilder.path("/{idOuNome}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesCasosDTO(casos));
    }

    @GetMapping("/doencas/{idOuNome}")
    public ResponseEntity<ListarCasosPorDoencaDTO> listarCasosPorDoenca(@PathVariable Long idOuNome, Pageable pageable){

        return ResponseEntity.ok(new ListaCasosPorDoencaDTO(service.listarCasosPorDoenca(idOuNome, pageable)));
    }

    @GetMapping("/cidades/{idOuNome}")
    public ResponseEntity<ListarCasosPorCidadeDTO> listarCasosPorCidade(@PathVariable String idOuNome, Pageable pageable){

        return ResponseEntity.ok(new ListaCasosPorCidadeDTO(service.listarCasosPorCidade(idOuNome, pageable)));
    }

    @GetMapping("/{idOuNomeCidade}/{idOuNomeDoenca}")
    public ResponseEntity<ListarCasosPorCidadeEDocencaDTO> listarCasosPorCidadeEDonca(@PathVariable String idOuNomeCidade, @PathVariable String idOuNomeDoenca, Pageable pageable){

        return ResponseEntity.ok(new ListaCasosPorCidadeEDoencaDTO(service.listarCasosPorCidadeEDoenca(idOuNomeCidade, idOuNomeDoenca, pageable)));
    }
}