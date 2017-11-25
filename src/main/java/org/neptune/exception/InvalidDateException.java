package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "StartDate and EndDate must be in proper order")
public class InvalidDateException extends RuntimeException
{
	private static final long serialVersionUID = -7294800358821566587L;

	public InvalidDateException()
	{
		super();
	}
}
