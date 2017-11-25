package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid email id, please enter correct email id")
public class InvalidEmailIdException extends RuntimeException
{
	private static final long serialVersionUID = 8457303495091127747L;

	public InvalidEmailIdException()
	{
		super();
	}
}
