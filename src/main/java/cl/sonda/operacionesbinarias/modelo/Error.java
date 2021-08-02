package cl.sonda.operacionesbinarias.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

	@JsonProperty("exceptionMensage")
	private String exceptionMensage;

	public String getExceptionMensage() {
		return exceptionMensage;
	}

	public void setExceptionMensage(String exceptionMensage) {
		this.exceptionMensage = exceptionMensage;
	}

	

}
