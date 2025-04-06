package br.com.epiControl.domain.repository;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICasosRepository extends JpaRepository<CasosEpidemiologicos, Long> {
    Boolean existsByCidadeIdAndDoencaId(@NotNull Long idCidade, @NotNull Long idDoenca);
}
