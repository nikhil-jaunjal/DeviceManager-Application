package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid 'userType', use '1' or '2' or '3'")
public class InvalidUserTypeException extends RuntimeException
{
	private static final long serialVersionUID = -228047344999334926L;

	public InvalidUserTypeException()
	{
		super();
	}
}
