package com.gft.books.handler;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.books.domain.DetalhesErro;
import com.gft.books.service.exception.AutorExistenteException;
import com.gft.books.service.exception.AutorNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<DetalhesErro> handleNoSuchElementException(NoSuchElementException e, HttpServletRequest request){
	
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.books.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
	
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.books.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
	
	//@ExceptionHandler(AutorExistenteException.class)
//	public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e, HttpServletRequest request){
//	
//		DetalhesErro erro = new DetalhesErro();
//		erro.setStatus(409l);
//		erro.setTitulo("O autor já existe.");
//		erro.setMensagemDesenvolvedor("http://erros.books.com/409");
//		erro.setTimestamp(System.currentTimeMillis());
//		
//		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
//	}
//	
//	@ExceptionHandler(AutorNaoEncontradoException.class)
//	public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest request){
//	
//		DetalhesErro erro = new DetalhesErro();
//		erro.setStatus(404l);
//		erro.setTitulo("O autor não foi encontrado.");
//		erro.setMensagemDesenvolvedor("http://erros.books.com/404");
//		erro.setTimestamp(System.currentTimeMillis());
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
//	}
	

