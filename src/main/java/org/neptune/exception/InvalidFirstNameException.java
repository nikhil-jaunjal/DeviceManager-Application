package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid first name")
public class InvalidFirstNameException extends RuntimeException
{
	private static final long serialVersionUID = -4054009160562362604L;

	public InvalidFirstNameException()
	{
		super();
	}
}
