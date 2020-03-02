package com.gft.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.books.domain.Autor;
import com.gft.books.repository.AutoresRepository;
import com.gft.books.service.exception.AutorExistenteException;
import com.gft.books.service.exception.AutorNaoEncontradoException;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.findById(autor.getId()).get();
			if(a != null) {
				throw new AutorExistenteException("Autor existente");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findById(id).get();
		if(autor == null) {
			throw new AutorNaoEncontradoException("Autor não encontrado");
		}
		return autor;
	}
}
