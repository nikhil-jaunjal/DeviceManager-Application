package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid last name")
public class InvalidLastNameException extends RuntimeException
{
	private static final long serialVersionUID = -5337540283841278064L;

	public InvalidLastNameException()
	{
		super();
	}
}
