package br.com.jeferson.bookstore.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jeferson.bookstore.exceptions.ObjectNotFoundException;
import br.com.jeferson.bookstore.exceptions.StandardError;
import br.com.jeferson.bookstore.exceptions.ValidationError;

@ControllerAdvice
public class ResourceExceptionHandler {

	private static final String VALIDATION_ERROR_MESSAGE = "Erro na validação dos campos.";

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception,
			ServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException exception,
			ServletRequest request) {

		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				VALIDATION_ERROR_MESSAGE);

		for (FieldError field : exception.getBindingResult().getFieldErrors()) {
			error.addErrors(field.getField(), field.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
