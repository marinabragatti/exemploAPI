package com.gft.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.books.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
