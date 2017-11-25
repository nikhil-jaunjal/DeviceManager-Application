package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "data related to you input not found in database, please try with another input")
public class DataNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -8526849792624105931L;

	public DataNotFoundException()
	{
		super();
	}
}
