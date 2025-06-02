package br.com.epiControl.domain.repository;

import br.com.epiControl.domain.model.CasosEpidemiologicos;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICasosRepository extends JpaRepository<CasosEpidemiologicos, Long> {
    Boolean existsByCidadeIdAndDoencaId(@NotNull Long idCidade, @NotNull Long idDoenca);

    Page<CasosEpidemiologicos> findAllByDoencaId(Long idDoenca, Pageable pageable);

    Page<CasosEpidemiologicos> findAllByCidadeId(Long id, Pageable pageable);

    Page<CasosEpidemiologicos> findAllByCidadeIdAndDoencaId(Long idCidade, Long idDoenca, Pageable pageable);

    CasosEpidemiologicos getReferenceByCidadeIdAndDoencaId(Long idCidade, Long idDoenca);
}
