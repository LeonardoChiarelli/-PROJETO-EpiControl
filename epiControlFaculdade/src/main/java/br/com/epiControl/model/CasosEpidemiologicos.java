package br.com.epiControl.model;

import jakarta.persistence.*;
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

    private Cidade cidade;
    private Doenca doenca;
    private LocalDate dataDeRegistro;
    private Integer numeroDeCasos;
    private Integer numeroDeObitos;
    private Integer numeroDeRecuperados;
    private Boolean status;
}
