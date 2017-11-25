package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="User of given userId already exists.")
public class UserAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = -6917341333838245536L;

	public UserAlreadyExistsException() {
		super();
	}
}
