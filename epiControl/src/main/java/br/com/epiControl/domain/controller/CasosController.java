package br.com.epiControl.domain.controller;

import br.com.epiControl.domain.dto.*;
import br.com.epiControl.domain.service.CasosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@RestController
@RequestMapping("/epiControl/casos")
public class CasosController {

    @Autowired
    private CasosService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCasosDTO> anexarCasos(@RequestBody @Valid AnexarCasosDTO dto, UriComponentsBuilder uriBuilder){
        var casos = service.anexar(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesCasosDTO(casos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesCasosDTO> detalharCaso(@PathVariable Long id){
        return ResponseEntity.ok(service.detalharCaso(id));
    }

    @GetMapping("/doencas/{idOuNome}")
    public ResponseEntity<Page<ListarCasosPorDoencaDTO>> listarCasosPorDoenca(@PathVariable String idOuNome, Pageable pageable){

        return ResponseEntity.ok(service.listarCasosPorDoenca(idOuNome, pageable));
    }

    @GetMapping("/cidades/{idOuNome}")
    public ResponseEntity<Page<ListarCasosPorCidadeDTO>> listarCasosPorCidade(@PathVariable String idOuNome, Pageable pageable){

        return ResponseEntity.ok(service.listarCasosPorCidade(idOuNome, pageable));
    }

    @GetMapping("/{idOuNomeCidade}/{idOuNomeDoenca}")
    public ResponseEntity<Page<ListarCasosPorCidadeEDocencaDTO>> listarCasosPorCidadeEDonca(@PathVariable String idOuNomeCidade, @PathVariable String idOuNomeDoenca, Pageable pageable){

        return ResponseEntity.ok(service.listarCasosPorCidadeEDoenca(idOuNomeCidade, idOuNomeDoenca, pageable));
    }

    @PutMapping("/{idOuNomeCidade}/{idOuNomeDoenca}")
    public ResponseEntity<DetalhesCasosDTO> atualizarDadosCasos(@PathVariable String idOuNomeCidade, @PathVariable String idOuNomeDoenca, @RequestBody @Valid AtualizarDadosCasosDTO dto){
        return ResponseEntity.ok(service.atualizarDados(idOuNomeCidade, idOuNomeDoenca, dto));
    }
}