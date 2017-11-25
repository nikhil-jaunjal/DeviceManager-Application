package org.neptune.service;

import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.UsageNotFoundException;
import org.neptune.mapper.DozerBeanMapper;
import org.neptune.model.DeviceEntity;
import org.neptune.model.DeviceUsage;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.repository.DeviceUsageDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.impl.DeviceUsageServiceInterface;
import org.neptune.validator.DeviceDtoValidator;
import org.neptune.validator.DeviceUsageDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceUsageService implements DeviceUsageServiceInterface
{
	@Autowired
	private DeviceUsageDAO deviceUsageRepo;
	@Autowired
	private DeviceUsageDtoValidator validator;
	@Autowired
	private DozerBeanMapper mapper;
	@Autowired
	private UserDAO userRepo;
	@Autowired
	private DeviceDAO deviceRepo;
	@Autowired
	private DeviceDtoValidator deviceDtoValidator;

	@Override
	public DeviceUsageDto save(DeviceUsageInputDto deviceUsageInDto)
	{
		validator.validateInputDto(deviceUsageInDto);
		UserEntity userEntity = userRepo.findOne(deviceUsageInDto.getUserId());
		DeviceEntity deviceEntity = deviceRepo.findOne(deviceUsageInDto.getDeviceId());
		if (userEntity == null || deviceEntity == null)
		{
			throw new DataNotFoundException();
		}
		DeviceUsage deviceUsage = mapper.map(deviceUsageInDto, DeviceUsage.class);
		deviceUsage.setUser(userEntity);
		deviceUsage.setDevice(deviceEntity);
		deviceUsageRepo.save(deviceUsage);
		
		deviceUsage = deviceUsageRepo.findOne(deviceUsage.getDeviceUsageId());
		DeviceUsageDto deviceUsageDto = mapper.map(deviceUsage, DeviceUsageDto.class);
		deviceUsageDto.setUserId(deviceUsage.getUser().getUserId());
		deviceUsageDto.setDeviceId(deviceUsage.getDevice().getDeviceId());
		
		return deviceUsageDto;
	}

	@Override
	public DeviceUsageDto update(DeviceUsageDto deviceUsageDto, Integer usageId)
	{
		DeviceUsage deviceUsage = deviceUsageRepo.findOne(usageId);
		if (deviceUsage == null)
		{
			throw new UsageNotFoundException();
		}
		validator.validate(deviceUsageDto);
		UserEntity userEntity = userRepo.findOne(deviceUsageDto.getUserId());
		DeviceEntity deviceEntity = deviceRepo.findOne(deviceUsageDto.getDeviceId());
		if (userEntity == null || deviceEntity == null)
		{
			throw new DataNotFoundException();
		}
		deviceUsage = mapper.map(deviceUsageDto, DeviceUsage.class);
		deviceUsage.setUser(userEntity);
		deviceUsage.setDevice(deviceEntity);
		deviceUsageRepo.save(deviceUsage);

		return deviceUsageDto;
	}

	@Override
	public void delete(Integer id)
	{
		deviceDtoValidator.checkDeviceId(id);
		DeviceUsage deviceUsage = deviceUsageRepo.findOne(id);
		validator.isEmptyEntity(deviceUsage);
		deviceUsageRepo.delete(id);
	}

}
