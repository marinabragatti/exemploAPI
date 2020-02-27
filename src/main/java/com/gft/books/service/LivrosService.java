package com.gft.books.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.books.domain.Comentario;
import com.gft.books.domain.Livro;
import com.gft.books.repository.ComentariosRepository;
import com.gft.books.repository.LivrosRepository;
import com.gft.books.service.exception.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository; 
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).get();
		
		if(livro == null) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
		return livro;
	}
	
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e){
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
	}
	
	
	public void atualizar(Livro livro) {
		verificaExistencia(livro);
		livrosRepository.save(livro);
	}
	
	
	private void verificaExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
}







