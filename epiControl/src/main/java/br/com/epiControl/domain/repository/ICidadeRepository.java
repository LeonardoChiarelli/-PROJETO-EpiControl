package br.com.epiControl.domain.repository;

import br.com.epiControl.domain.model.Cidade;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICidadeRepository extends JpaRepository<Cidade, Long> {
    
    Boolean existsByNome(@NotBlank String nome);

    Optional<Cidade> findByNome(String idOuNome);
}
