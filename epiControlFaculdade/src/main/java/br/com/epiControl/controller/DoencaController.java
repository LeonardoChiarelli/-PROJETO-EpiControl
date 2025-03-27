package br.com.epiControl.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/epiControl/doenca")
public class DoencaController {

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDoencaDTO> registrarDoenca(@RequestBody @Valid CadastrarDoencaDTO dto, UriComponentsBuilder uriBuilder){
        var doenca = service.cadastrar(dto);

        var uri = uriBuilder.path("{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesDoencaDTO(doenca));
    }

    @GetMapping("/listar")
    public ResponseEntity<ListaDoencasDTO> listarDoenca(Pageable pageable){
        return ResponseEntity.ok(new ListaDoencasDTO(service.listar(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoencaDTO> detalharDoenca(@PathVariable Long id){
        return ResponseEntity.ok(new DetalhesDoencaDTO(service.detalhar(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizarDados(@RequestBody @Valid AtualizarDadosDoencaDTO dto){
        service.atualizar(dto);

        return ResponseEntity.ok("Dados atualizados");
    }
}
