package org.neptune.validator;

import java.util.List;

import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.InvalidDeviceIdException;
import org.neptune.exception.InvalidDeviceStateException;
import org.neptune.exception.InvalidDeviceTypeException;
import org.neptune.exception.InvalidModelNumberException;
import org.neptune.model.DeviceEntity;
import org.springframework.stereotype.Service;

@Service
public class DeviceDtoValidator
{
	public void validateInputDto(DeviceInputDto deviceInDto)
	{
		checkDeviceType(deviceInDto.getDeviceType());
		checkState(deviceInDto.getState());
		checkModel(deviceInDto.getModelNumber());
	}
	public void validateUpdateDto(DeviceUpdateDto deviceUpdateDto)
	{
		checkDeviceId(deviceUpdateDto.getDeviceId());
		checkDeviceType(deviceUpdateDto.getDeviceType());
		checkState(deviceUpdateDto.getState());
		checkModel(deviceUpdateDto.getModelNumber());
	}

	public void checkModel(String modelNumber)
	{
		if (!(modelNumber.matches("[a-zA-Z0-9-\\s]+")))
		{
			throw new InvalidModelNumberException();
		}
	}

	public void checkDeviceId(Integer deviceId)
	{
		if (deviceId <= 0)
		{
			throw new InvalidDeviceIdException();
		}
	}

	public void checkState(Integer state)
	{
		if (!(state == 1 || state == 2 || state == 3 || state == 4))
		{
			throw new InvalidDeviceStateException();
		}
	}

	public void checkDeviceType(String deviceType)
	{
		if (!(deviceType.matches("[a-zA-Z]+")))
		{
			throw new InvalidDeviceTypeException();
		}
	}

	public void isEmptyEntity(DeviceEntity deviceEntity)
	{
		if (deviceEntity == null)
		{
			throw new DataNotFoundException();
		}
	}

	public void isEmptyEntityList(List<?> entityList)
	{
		if (entityList.isEmpty())
		{
			throw new DataNotFoundException();
		}
	}

}
