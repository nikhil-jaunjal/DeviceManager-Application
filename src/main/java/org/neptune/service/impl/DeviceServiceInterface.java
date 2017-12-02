package org.neptune.service.impl;

import java.util.List;

import org.neptune.dto.DeviceCustomOutDto;
import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceOutDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.enums.DeviceState;

public interface DeviceServiceInterface
{
	public DeviceOutDto save(DeviceInputDto deviceInDTO);

	public DeviceOutDto update(DeviceUpdateDto deviceUpdateDTO, Integer deviceId);

	public void delete(Integer id);

	public DeviceOutDto findByDeviceId(Integer id);

	public List<DeviceCustomOutDto> findUsersOfDevice(Integer deviceId);

	public List<DeviceOutDto> findDevices(String type, DeviceState state);
}
