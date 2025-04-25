package br.com.epiControl.domain.controller;

import br.com.epiControl.domain.dto.CadastrarDoencaDTO;
import br.com.epiControl.domain.dto.DetalhesDoencaDTO;
import br.com.epiControl.domain.dto.ListaDoencasDTO;
import br.com.epiControl.domain.service.DoencaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/epiControl/doenca")
public class DoencaController {

    @Autowired
    private DoencaService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDoencaDTO> registrarDoenca(@RequestBody @Valid CadastrarDoencaDTO dto, UriComponentsBuilder uriBuilder){
        var doenca = service.cadastrar(dto);

        var uri = uriBuilder.path("{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesDoencaDTO(doenca));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<ListaDoencasDTO>> listarDoenca(Pageable pageable){
        return ResponseEntity.ok(service.listar(pageable).map(ListaDoencasDTO::new));
    }

    @GetMapping("/{idOuNome}")
    public ResponseEntity<DetalhesDoencaDTO> detalharDoenca(@PathVariable String idOuNome){
        return ResponseEntity.ok(service.detalhar(idOuNome));
    }
}
