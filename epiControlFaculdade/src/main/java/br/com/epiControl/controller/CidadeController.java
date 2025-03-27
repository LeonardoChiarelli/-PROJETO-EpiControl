package br.com.epiControl.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/epiControl/cidade")
public class CidadeController {

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCidadeDTO> cadastrarCidade(@RequestBody @Valid CadastrarCidadeDTO dto, UriComponentsBuilder uriBuilder){
        var cidade = service.cadastrar(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesCidadeDTO(cidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesCidadeDTO> detalharCidade(@PathVariable Long id){
        return ResponseEntity.ok(new DetalhesCidadeDTO(service.detalhar(id)));
    }
}
