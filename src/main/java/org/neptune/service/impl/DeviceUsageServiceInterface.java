package org.neptune.service.impl;

import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;

public interface DeviceUsageServiceInterface
{
	public DeviceUsageDto save(DeviceUsageInputDto deviceUsageDTO);

	public DeviceUsageDto update(DeviceUsageDto deviceUsageDto, Integer usageId);

	public void delete(Integer id);
}
