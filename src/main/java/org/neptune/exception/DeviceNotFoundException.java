package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Device of given deviceId does not exists!!")
public class DeviceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 7711461375562874601L;

	public DeviceNotFoundException()
	{
		super();
	}
}
