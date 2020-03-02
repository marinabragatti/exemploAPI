package com.gft.books.service.exception;

public class AutorNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -558649793858125669L;

	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
