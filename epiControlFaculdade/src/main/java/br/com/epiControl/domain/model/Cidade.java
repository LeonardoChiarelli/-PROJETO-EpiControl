package br.com.epiControl.domain.model;

import br.com.epiControl.domain.dto.AtualizarDadosCidadeDTO;
import br.com.epiControl.domain.dto.CadastrarCidadeDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cidades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String estado;

    private Double populacao;
    private Integer quantidadeHospitais;
    private Integer quantidadePostosDeSaude;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CasosEpidemiologicos> casosEpidemiologicos;

    public Cidade(@Valid CadastrarCidadeDTO dto) {
        this.nome = dto.nome();
        this.estado = dto.siglaEstado();
        this.populacao = dto.populacao();
        this.quantidadeHospitais = dto.quantidadeHospitais();
        this.quantidadePostosDeSaude = dto.quantidadePostosDeSaude();
    }

    public void atualizarInfo(AtualizarDadosCidadeDTO dto) {
        if (dto.populacao() != null){ this.populacao = dto.populacao(); }
        if (dto.quantidadeHospitais() != null){ this.quantidadeHospitais = dto.quantidadeHospitais(); }
        if (dto.quantidadePostosDeSaude() != null){ this.quantidadePostosDeSaude = dto.quantidadePostosDeSaude(); }
    }
}
