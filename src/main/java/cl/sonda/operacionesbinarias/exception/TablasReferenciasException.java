package cl.sonda.operacionesbinarias.exception;

public class TablasReferenciasException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String messageException;

	public String getMessageException() {
		return messageException;
	}

	public TablasReferenciasException(String messageException) {
		super();
		this.messageException = messageException;
	}

}
