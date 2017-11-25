package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "incorrect model number")
public class InvalidModelNumberException extends RuntimeException
{
	private static final long serialVersionUID = -3003350508193789892L;

	public InvalidModelNumberException()
	{
		super();
	}
}
