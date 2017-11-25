package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "userId must be of format 'nitXXX' ( X represents number )")
public class InvalidUserIdException extends RuntimeException
{
	private static final long serialVersionUID = 3662391296424075854L;

	public InvalidUserIdException()
	{
		super();
	}
}
