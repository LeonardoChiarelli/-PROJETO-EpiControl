package br.com.epiControl.domain.model;

import br.com.epiControl.domain.dto.AtualizarDadosDoencaDTO;
import br.com.epiControl.domain.dto.CadastrarDoencaDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private List<AgenteCausador> agenteCausador;

    private List<String> sintomas;
    private List<String> formasDeTransmissao;
    private List<String> medidasDePrevencao;

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

    public void retirarInformacoes(AtualizarDadosDoencaDTO dto){
        if (dto.agenteCausador() != null) { this.agenteCausador.removeAll(dto.agenteCausador()); }
        if (dto.sintomas() != null) { this.sintomas.removeAll(dto.sintomas()); }
        if (dto.formasDeTransmissao() != null) { this.formasDeTransmissao.removeAll(dto.formasDeTransmissao()); }
        if (dto.medidasDePrevencao() != null) { this.medidasDePrevencao.removeAll(dto.medidasDePrevencao()); }
    }

    public void adicionarInformacoes(AtualizarDadosDoencaDTO dto){
        if (dto.agenteCausador() != null) { this.agenteCausador.addAll(dto.agenteCausador()); }
        if (dto.sintomas() != null) { this.sintomas.addAll(dto.sintomas()); }
        if (dto.formasDeTransmissao() != null) { this.formasDeTransmissao.addAll(dto.formasDeTransmissao()); }
        if (dto.medidasDePrevencao() != null) { this.medidasDePrevencao.addAll(dto.medidasDePrevencao()); }
        if (dto.taxaDeTransmissao() != null) { this.taxaDeTransmissao = dto.taxaDeTransmissao(); }
    }

    public void adicionarTaxaDeMortalidade(){}
}
