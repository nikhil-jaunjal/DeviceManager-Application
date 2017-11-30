package org.neptune.validator;

import java.util.Date;

import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.InvalidDateException;
import org.neptune.exception.InvalidDeviceUsageIdException;
import org.neptune.model.DeviceUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceUsageDtoValidator
{
	@Autowired
	private DeviceDtoValidator deviceDtoValidator;
	@Autowired
	private UserDtoValidator userDtoValidator;

	public void validate(DeviceUsageDto deviceUsageDto)
	{
		userDtoValidator.checkUserId(deviceUsageDto.getUserId());
		deviceDtoValidator.checkDeviceId(deviceUsageDto.getDeviceId());
		checkDeviceUsageId(deviceUsageDto.getDeviceUsageId());
		checkDates(deviceUsageDto.getStartDate(), deviceUsageDto.getEndDate());
	}

	public void validateInputDto(DeviceUsageInputDto deviceUsageInDto)
	{
		userDtoValidator.checkUserId(deviceUsageInDto.getUserId());
		deviceDtoValidator.checkDeviceId(deviceUsageInDto.getDeviceId());
		checkDates(deviceUsageInDto.getStartDate(), deviceUsageInDto.getEndDate());
	}

	public void checkDates(Date startDate, Date endDate)
	{
		if (startDate != null && endDate != null && startDate.compareTo(endDate) > 0)
		{
			throw new InvalidDateException();
		}
		if (startDate == null)
		{
			throw new InvalidDateException();
		}
	}

	public void checkDeviceUsageId(Integer deviceUsageId)
	{
		if (deviceUsageId <= 0)
		{
			throw new InvalidDeviceUsageIdException();
		}
	}

	public void isEmptyEntity(DeviceUsage deviceUsage)
	{
		if (deviceUsage == null)
		{
			throw new DataNotFoundException();
		}
	}
}
