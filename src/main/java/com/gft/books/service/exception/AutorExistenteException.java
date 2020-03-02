package com.gft.books.service.exception;

public class AutorExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -558649793858125669L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
