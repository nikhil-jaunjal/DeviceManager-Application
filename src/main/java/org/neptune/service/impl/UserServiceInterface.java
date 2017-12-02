package org.neptune.service.impl;

import java.util.List;

import org.neptune.dto.UserCustomOutDto;
import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.enums.UserType;

public interface UserServiceInterface
{
	public UserOutDto save(UserInputDto userInDto);

	public UserOutDto update(UserInputDto userInDto, String userId);

	public void delete(String id);

	public List<UserOutDto> findUsers(String firstName, String lastName, UserType type);

	public UserOutDto findByUserId(String userId);

	public List<UserCustomOutDto> findDevicesOfUser(String userId);
}
