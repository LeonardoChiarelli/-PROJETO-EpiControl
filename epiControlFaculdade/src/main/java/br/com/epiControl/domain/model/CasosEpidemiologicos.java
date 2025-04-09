package br.com.epiControl.domain.model;

import br.com.epiControl.domain.dto.AnexarCasosDTO;
import br.com.epiControl.domain.dto.AtualizarDadosCasosDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "casos_epidemiologicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CasosEpidemiologicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @JoinColumn(name = "doenca_id")
    private Doenca doenca;

    private LocalDate dataDeRegistro;
    private LocalDate ultimaAtualizacao;
    private Integer numeroDeCasos;
    private Integer numeroDeObitos;
    private Integer numeroDeRecuperados;
    private Boolean status;

    public CasosEpidemiologicos(@Valid AnexarCasosDTO dto, Cidade cidade, Doenca doenca) {
        this.cidade = cidade;
        this.doenca = doenca;
        this.dataDeRegistro = LocalDate.now();
        this.ultimaAtualizacao = LocalDate.now();
        this.numeroDeCasos = dto.numeroDeCasos();
        this.numeroDeObitos = dto.numeroDeObitos();
        this.numeroDeRecuperados = dto.numeroDeRecuperados();
        this.status = true;
    }

    public CasosEpidemiologicos(Cidade cidade, Doenca doenca, LocalDate dataDeRegistro, @Valid AtualizarDadosCasosDTO dto) {
        this.cidade = cidade;
        this.doenca = doenca;
        this.dataDeRegistro = dataDeRegistro;
        this.ultimaAtualizacao = LocalDate.now();
        this.numeroDeCasos = dto.numeroDeCasos();
        this.numeroDeObitos = dto.numeroDeObitos();
        this.numeroDeRecuperados = dto.numeroDeRecuperados();
        this.status = dto.status();
    }
}
