package br.com.senai.confeitaria.domain;

public class ErroMsg {
	private String messageError;

	public ErroMsg(String message) {
		messageError = message;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
