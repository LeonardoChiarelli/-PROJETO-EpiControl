package br.com.epiControl.domain.model;

import br.com.epiControl.domain.dto.CadastrarDoencaDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doencas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String agenteCausador;
    private String sintomas;
    private String formasDeTransmissao;
    private String medidasDePrevencao;

    @Column(name = "taxa_de_mortalidade(%)")
    private Double taxaDeMortalidade; // obitos/casos confirmados

    @Column(name = "taxa_de_transmissao(%)")
    private Double taxaDeTransmissao; // num médio de pessoas infectadas por um doente

    public Doenca(@Valid CadastrarDoencaDTO dto) {
        this.nome = dto.nome();
        this.agenteCausador = dto.agenteCausador();
        this.sintomas = dto.sintomas();
        this.formasDeTransmissao = dto.formasDeTransmissao();
        this.medidasDePrevencao = dto.medidasDePrevencao();
        this.taxaDeTransmissao = dto.taxaDeTransmissao();
    }

    public void adicionarTaxaDeMortalidade(){}
}
