package br.com.epiControl.model;

import jakarta.persistence.*;
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
    private AgenteCausador agenteCausador;

    private List<String> sintomas;
    private List<String> formasDeTransmissao;
    private List<String> medidasDePrevencao;
    private Double taxaDeMortalidade; // obitos/casos confirmados
    private Double taxaDeTransmissao; // num médio de pessoas infectadas por um doente

}
