package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "user does not exists!!")
public class UserDoesNotExistsException extends RuntimeException
{
	private static final long serialVersionUID = -8663440472702664883L;

	public UserDoesNotExistsException()
	{
		super();
	}
}
