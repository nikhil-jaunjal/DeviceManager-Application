
package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "state should be '1' or '2' or '3' or '4'")
public class InvalidDeviceStateException extends RuntimeException
{
	private static final long serialVersionUID = -7294800358821566587L;

	public InvalidDeviceStateException()
	{
		super();
	}
}