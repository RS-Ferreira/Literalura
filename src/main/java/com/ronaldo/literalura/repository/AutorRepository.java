package com.ronaldo.literalura.repository;

import java.util.Optional;
import com.ronaldo.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNome(String nome);

}