package br.com.jeferson.bookstore.exceptions;

public class StandardError {

	private Long timeStamp;
	private Integer status;
	private String messageError;

	public StandardError(Long timeStamp, Integer status, String messageError) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.messageError = messageError;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
