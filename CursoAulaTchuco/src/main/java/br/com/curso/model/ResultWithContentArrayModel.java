package br.com.curso.model;

import java.io.Serializable;
import java.util.List;

public class ResultWithContentArrayModel<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String message;
	private List<String> errors;
	private List<T> content;
	
	public ResultWithContentArrayModel(int code, String message, List<String> errors, List<T> content) {
		this.code = code;
		this.message = message;
		this.errors = errors;
		this.content = content;
	}
	
	public ResultWithContentArrayModel() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	
	
	
}
