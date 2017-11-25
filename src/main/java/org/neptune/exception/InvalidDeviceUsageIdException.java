package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid deviceUsageId, please enter Integer type")
public class InvalidDeviceUsageIdException extends RuntimeException
{
	private static final long serialVersionUID = 523599053788981547L;

	public InvalidDeviceUsageIdException()
	{
		super();
	}
}
