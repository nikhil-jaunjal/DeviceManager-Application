package org.neptune.service;

import java.util.ArrayList;
import java.util.List;

import org.neptune.dto.UserCustomOutDto;
import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.enums.UserType;
import org.neptune.exception.UserAlreadyExistsException;
import org.neptune.exception.UserDoesNotExistsException;
import org.neptune.mapper.DozerBeanMapper;
import org.neptune.model.DeviceEntity;
import org.neptune.model.DeviceUsage;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.repository.DeviceUsageDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.impl.UserServiceInterface;
import org.neptune.validator.UserDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface
{
	@Autowired
	private UserDAO userRepo;
	@Autowired
	private DeviceDAO deviceRepo;
	@Autowired
	private DeviceUsageDAO userDeviceRepo;
	@Autowired
	private UserDtoValidator validator;
	@Autowired
	private DozerBeanMapper mapper;

	@Override

	public UserOutDto save(UserInputDto userInDto)
	{
		validator.validate(userInDto);
		UserEntity userEntity = userRepo.findOne(userInDto.getUserId());
		if (userEntity != null)
		{
			throw new UserAlreadyExistsException();
		}
		userEntity = mapper.map(userInDto, UserEntity.class);
		userRepo.save(userEntity);
		return (mapper.map(userEntity, UserOutDto.class));
	}

	@Override
	public UserOutDto update(UserInputDto userDto, String userId)
	{
		UserEntity userEntity = userRepo.findOne(userId);
		if (userEntity == null)
		{
			throw new UserDoesNotExistsException();
		}
		validator.validate(userDto);
		userEntity = mapper.map(userDto, UserEntity.class);
		userRepo.save(userEntity);
		return (mapper.map(userEntity, UserOutDto.class));
	}

	@Override
	public void delete(String userId)
	{
		validator.checkUserId(userId);
		UserEntity userEntity = userRepo.findOne(userId);
		if (userEntity == null)
		{
			throw new UserDoesNotExistsException();
		}
		userRepo.delete(userId);
	}

	@Override
	public List<UserOutDto> findUsers(String firstName, String lastName, UserType type)
	{
		List<UserEntity> userEntityList;
		if (firstName == null && lastName == null && type == null)
		{
			userEntityList = userRepo.findAll();
		} else if (type == null && firstName != null && lastName != null)
		{
			validator.checkFirstName(firstName);
			validator.checkLastName(lastName);
			userEntityList = userRepo.findByFirstNameAndLastName(firstName, lastName);
		} else if (type == null && firstName == null)
		{
			validator.checkLastName(lastName);
			userEntityList = userRepo.findByLastName(lastName);
		} else if (type != null && firstName == null && lastName == null)
		{
			validator.checkUserType(type);
			userEntityList = userRepo.findByUserType(type);
		} else if (type != null && firstName == null)
		{
			validator.checkUserType(type);
			validator.checkLastName(lastName);
			userEntityList = userRepo.findByUserTypeAndLastName(type, lastName);
		} else if (type != null && lastName == null)
		{
			validator.checkFirstName(firstName);
			validator.checkUserType(type);
			userEntityList = userRepo.findByFirstNameAndUserType(firstName, type);
		} else if (lastName == null)
		{
			validator.checkFirstName(firstName);
			userEntityList = userRepo.findByFirstName(firstName);
		} else
		{
			validator.checkFirstName(firstName);
			validator.checkLastName(lastName);
			validator.checkUserType(type);
			userEntityList = userRepo.findByFirstNameAndLastNameAndUserType(firstName, lastName, type);
		}
		List<UserOutDto> userOutDtoList = new ArrayList<>();
		for (UserEntity userEntity : userEntityList)
		{
			UserOutDto userOutDto = mapper.map(userEntity, UserOutDto.class);
			userOutDtoList.add(userOutDto);
		}
		return userOutDtoList;
	}

	@Override
	public UserOutDto findByUserId(String userId)
	{
		validator.checkUserId(userId);
		UserEntity userEntity = userRepo.findOne(userId);
		return (mapper.map(userEntity, UserOutDto.class));
	}

	@Override
	public List<UserCustomOutDto> findDevicesOfUser(String userId)
	{
		validator.checkUserId(userId);
		List<UserCustomOutDto> userCustomOutDtoList = new ArrayList<>();
		List<DeviceUsage> deviceUsageList = userDeviceRepo.findByUserUserId(userId);
		for (DeviceUsage deviceUsage : deviceUsageList)
		{
			String userid = deviceUsage.getUser().getUserId();
			Integer deviceid = deviceUsage.getDevice().getDeviceId();

			UserEntity userEntity = userRepo.findOne(userid);
			DeviceEntity deviceEntity = deviceRepo.findOne(deviceid);

			UserCustomOutDto customOutDto = new UserCustomOutDto();
			customOutDto.setDeviceId(deviceEntity.getDeviceId());
			customOutDto.setUserId(userEntity.getUserId());
			customOutDto.setDeviceName(deviceEntity.getDeviceName());
			customOutDto.setDeviceType(deviceEntity.getDeviceType());
			customOutDto.setModelNumber(deviceEntity.getModelNumber());
			customOutDto.setStartDate(deviceUsage.getStartDate());
			customOutDto.setEndDate(deviceUsage.getEndDate());

			userCustomOutDtoList.add(customOutDto);
		}
		return userCustomOutDtoList;
	}

}
