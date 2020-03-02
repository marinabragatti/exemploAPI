package com.gft.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.books.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
