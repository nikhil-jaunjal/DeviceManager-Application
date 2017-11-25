package org.neptune.service.tests;

import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;

public class UserDataProvider
{
	public UserInputDto createDefaultInputDTForSaveFunction()
	{
		UserInputDto userInputDto = new UserInputDto();
		userInputDto.setUserId("nit0101"); // id should not be present in db
		userInputDto.setFirstName("nik");
		userInputDto.setLastName("jaunjal");
		userInputDto.setEmail("nikhil.jaunjal@gmail.com");
		userInputDto.setUserType(3);
		return userInputDto;
	}

	public UserOutDto createDefualtOutDTOForSaveFunction()
	{
		UserOutDto expectedUserOutDto = new UserOutDto();
		expectedUserOutDto.setUserId("nit0101");
		expectedUserOutDto.setFirstName("nik");
		expectedUserOutDto.setLastName("jaunjal");
		expectedUserOutDto.setEmail("nikhil.jaunjal@gmail.com");
		expectedUserOutDto.setUserType("END_USER");
		return expectedUserOutDto;
	}

	public UserInputDto createDefaultInputDTForUpdateFunction()
	{
		UserInputDto userInputDto = new UserInputDto();
		userInputDto.setUserId("nit090"); // id should be present in db.
		userInputDto.setFirstName("nikhil");
		userInputDto.setLastName("jaunjal");
		userInputDto.setEmail("nikhil.jaunjal@neptune-ubi.com");
		userInputDto.setUserType(1);
		return userInputDto;
	}

	public UserOutDto createDefualtOutDTOUpdateFunction()
	{
		UserOutDto expectedUserOutDto = new UserOutDto();
		expectedUserOutDto.setUserId("nit090");
		expectedUserOutDto.setFirstName("nikhil");
		expectedUserOutDto.setLastName("jaunjal");
		expectedUserOutDto.setEmail("nikhil.jaunjal@neptune-ubi.com");
		expectedUserOutDto.setUserType("GLOBAL_ADMIN");
		return expectedUserOutDto;
	}

	public UserOutDto outDtoForFindUsers()
	{
		UserOutDto expectedUserOutDto = new UserOutDto();
		expectedUserOutDto.setUserId("nit090");
		expectedUserOutDto.setFirstName("nikhil");
		expectedUserOutDto.setLastName("jaunjal");
		expectedUserOutDto.setEmail("nikhil.jaunjal@neptune-ubi.com");
		expectedUserOutDto.setUserType("GLOBAL_ADMIN");
		return expectedUserOutDto;
	}
}
