package com.gft.books.service.exception;

public class LivroNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -558649793858125669L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
