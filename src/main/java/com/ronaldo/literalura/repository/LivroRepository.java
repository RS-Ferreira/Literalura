package com.ronaldo.literalura.repository;

import com.ronaldo.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}