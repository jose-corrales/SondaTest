package cl.sonda.operacionesbinarias.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.sonda.operacionesbinarias.modelo.DataWS;
import cl.sonda.operacionesbinarias.util.Utils;


@RestController
public class OperacionesBinariasController {

	@PostMapping("/operation")
    public DataWS operation(@RequestBody DataWS registryNumber){	
		return Utils.loadOperation(registryNumber);
	}
	
}
