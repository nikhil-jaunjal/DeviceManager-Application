package org.neptune.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "deviceUsageId does not exists!!")
public class UsageNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1341342241989761020L;

	public UsageNotFoundException()
	{
		super();
	}
}
