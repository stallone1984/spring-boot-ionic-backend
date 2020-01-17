package com.nelioalves.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String mensagem, Long timestamp) {
		super(status, mensagem, timestamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String filedName, String message) {
		errors.add(new FieldMessage(filedName, message));
	}

	
}
