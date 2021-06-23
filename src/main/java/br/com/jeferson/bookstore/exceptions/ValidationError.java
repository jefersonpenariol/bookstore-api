package br.com.jeferson.bookstore.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Long timeStamp, Integer status, String messageError) {
		super(timeStamp, status, messageError);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String nomeCampo, String mensagem) {
		this.errors.add(new FieldMessage(nomeCampo, mensagem));
	}

	
}