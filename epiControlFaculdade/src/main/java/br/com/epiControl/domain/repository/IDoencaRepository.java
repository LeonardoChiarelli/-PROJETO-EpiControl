package br.com.epiControl.domain.repository;

import br.com.epiControl.domain.model.Doenca;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDoencaRepository extends JpaRepository<Doenca, Long> {

    Boolean existsByNome(@NotBlank String nome);

    Optional<Doenca> findByNome(String idOuNome);
}
