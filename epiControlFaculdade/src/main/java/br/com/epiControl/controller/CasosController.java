package br.com.epiControl.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.chrono.IsoEra;

@RestController
@RequestMapping("/epiControl/casos")
public class CasosController {

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