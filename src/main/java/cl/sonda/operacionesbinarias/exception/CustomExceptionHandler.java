package cl.sonda.operacionesbinarias.exception;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.sonda.operacionesbinarias.modelo.Error;

@ControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler({ TablasReferenciasException.class })
	public ResponseEntity<Error> handleServiceException(TablasReferenciasException e) {	
		Error excp =new Error();
		excp.setExceptionMensage(Optional.ofNullable(e.getMessageException()).orElse("unhandled exception"));
		
		return new ResponseEntity<>(excp,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
