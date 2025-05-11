package br.com.epiControl.domain.controller;

import br.com.epiControl.domain.dto.AtualizarDadosCidadeDTO;
import br.com.epiControl.domain.dto.CadastrarCidadeDTO;
import br.com.epiControl.domain.dto.DetalhesCidadeDTO;
import br.com.epiControl.domain.dto.ListaCidadesDTO;
import br.com.epiControl.domain.helper.HelperMethod;
import br.com.epiControl.domain.service.CidadeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/epiControl/cidade")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCidadeDTO> cadastrarCidade(@RequestBody @Valid CadastrarCidadeDTO dto, UriComponentsBuilder uriBuilder){
        var cidade = service.cadastrar(dto);

        var uri = uriBuilder.path("/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesCidadeDTO(cidade));
    }

    @GetMapping
    public ResponseEntity<Page<ListaCidadesDTO>> listarCidades(Pageable pageable){
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{idOuNome}")
    public ResponseEntity<DetalhesCidadeDTO> detalharCidade(@PathVariable String idOuNome){
        return ResponseEntity.ok(new DetalhesCidadeDTO(service.detalhar(idOuNome)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhesCidadeDTO> atualizarInformacoesCidade(AtualizarDadosCidadeDTO dto){

        return ResponseEntity.ok(new DetalhesCidadeDTO(service.atualizarInfo(dto)));
    }
}
