package com.gft.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.books.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

	
}
