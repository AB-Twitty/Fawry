package FawrySystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtNotFoundException extends EtException{

	public EtNotFoundException(String message) {
		super(message);
	}
}
