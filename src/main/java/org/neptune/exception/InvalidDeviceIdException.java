package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid deviceId, please enter integer value")
public class InvalidDeviceIdException extends RuntimeException
{
	private static final long serialVersionUID = -4202878563704567328L;

	public InvalidDeviceIdException()
	{
		super();
	}
}
