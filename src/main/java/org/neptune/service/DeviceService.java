package org.neptune.service;

import java.util.ArrayList;
import java.util.List;

import org.neptune.dto.DeviceCustomOutDto;
import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceOutDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.enums.DeviceState;
import org.neptune.exception.DeviceNotFoundException;
import org.neptune.mapper.DozerBeanMapper;
import org.neptune.model.DeviceEntity;
import org.neptune.model.DeviceUsage;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.repository.DeviceUsageDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.impl.DeviceServiceInterface;
import org.neptune.validator.DeviceDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService implements DeviceServiceInterface
{
	@Autowired
	private DeviceDAO deviceRepo;
	@Autowired
	private UserDAO userRepo;
	@Autowired
	private DeviceUsageDAO deviceUsageRepo;
	@Autowired
	private DozerBeanMapper mapper;
	@Autowired
	private DeviceDtoValidator validator;

	@Override
	public DeviceOutDto save(DeviceInputDto deviceInDto)
	{
		validator.validateInputDto(deviceInDto);
		DeviceEntity deviceEntity = mapper.map(deviceInDto, DeviceEntity.class);
		deviceRepo.save(deviceEntity);
		deviceEntity = deviceRepo.findOne(deviceEntity.getDeviceId());
		DeviceOutDto deviceOutDto = mapper.map(deviceEntity, DeviceOutDto.class);
		deviceOutDto.setState(setEnumValueOfKey(deviceEntity.getState()));

		return deviceOutDto;
	}

	@Override
	public DeviceOutDto update(DeviceUpdateDto deviceUpdateDto, Integer deviceId)
	{
		if (deviceRepo.findOne(deviceId) == null)
		{
			throw new DeviceNotFoundException();
		}
		validator.validateUpdateDto(deviceUpdateDto);
		DeviceEntity deviceEntity = mapper.map(deviceUpdateDto, DeviceEntity.class);
		deviceRepo.save(deviceEntity);
		deviceEntity = deviceRepo.findOne(deviceId);
		DeviceOutDto deviceOutDto = mapper.map(deviceEntity, DeviceOutDto.class);
		deviceOutDto.setState(setEnumValueOfKey(deviceEntity.getState()));

		return deviceOutDto;
	}

	@Override
	public void delete(Integer id)
	{
		DeviceEntity deviceEntity = deviceRepo.findOne(id);
		validator.isEmptyEntity(deviceEntity);
		deviceRepo.delete(id);
	}

	@Override
	public DeviceOutDto findByDeviceId(Integer id)
	{
		DeviceEntity deviceEntity = deviceRepo.findOne(id);
		validator.isEmptyEntity(deviceEntity);
		DeviceOutDto deviceOutDto = mapper.map(deviceEntity, DeviceOutDto.class);
		deviceOutDto.setState(setEnumValueOfKey(deviceEntity.getState()));

		return deviceOutDto;
	}

	@Override
	public List<DeviceCustomOutDto> findUsersOfDevice(Integer deviceId)
	{
		List<DeviceCustomOutDto> deviceCustomOutDtoList = new ArrayList<>();
		List<DeviceUsage> deviceUsageList = deviceUsageRepo.findByDeviceDeviceId(deviceId);
		validator.isEmptyEntityList(deviceUsageList);
		for (DeviceUsage deviceUsage : deviceUsageList)
		{
			String userid = deviceUsage.getUser().getUserId();
			Integer deviceid = deviceUsage.getDevice().getDeviceId();

			UserEntity userEntity = userRepo.findOne(userid);
			DeviceEntity deviceEntity = deviceRepo.findOne(deviceid);

			DeviceCustomOutDto customOutDto = new DeviceCustomOutDto();
			customOutDto.setDeviceId(deviceEntity.getDeviceId());
			customOutDto.setDeviceType(deviceEntity.getDeviceType());
			customOutDto.setModelNumber(deviceEntity.getModelNumber());
			customOutDto.setUserId(userEntity.getUserId());
			customOutDto.setEmail(userEntity.getEmail());
			customOutDto.setFirstName(userEntity.getFirstName());
			customOutDto.setLastName(userEntity.getLastName());
			customOutDto.setStartDate(deviceUsage.getStartDate());
			customOutDto.setEndDate(deviceUsage.getEndDate());

			deviceCustomOutDtoList.add(customOutDto);
		}
		return deviceCustomOutDtoList;
	}

	public List<DeviceOutDto> findDevices(String type, Integer state)
	{
		List<DeviceEntity> deviceEntityList;
		if (type == null && state == null)
		{
			deviceEntityList = deviceRepo.findAll();
		} else if (type != null && state == null)
		{
			deviceEntityList = deviceRepo.findByDeviceType(type);
		} else if (type == null)
		{
			deviceEntityList = deviceRepo.findByState(state);
		} else
		{
			deviceEntityList = deviceRepo.findByDeviceTypeAndState(type, state);
		}
		List<DeviceOutDto> deviceDtoList = new ArrayList<>();
		validator.isEmptyEntityList(deviceEntityList);
		for (DeviceEntity deviceEntity : deviceEntityList)
		{
			DeviceOutDto dto = mapper.map(deviceEntity, DeviceOutDto.class);
			dto.setState(setEnumValueOfKey(deviceEntity.getState()));
			deviceDtoList.add(dto);
		}
		return deviceDtoList;
	}

	private String setEnumValueOfKey(Integer key)
	{
		String value = null;
		for (DeviceState s : DeviceState.values())
		{
			if (s.getKey() == key)
			{
				value = s.getValue();
			}
		}
		return value;
	}
}
