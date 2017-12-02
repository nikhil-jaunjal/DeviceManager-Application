package org.neptune.service.tests;

import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.enums.UserType;
import org.neptune.model.UserEntity;
import org.testng.annotations.DataProvider;

public class UserDataProvider
{
	@DataProvider
	public static Object[][] dataProviderMethod1()
	{
		UserInputDto inDto = createDefaultInputDTForSaveFunction();

		return new Object[][] { { inDto } };
	}

	@DataProvider
	public static Object[][] dataProviderMethod2()
	{
		UserInputDto inDto = createDefaultInputDTForSaveFunction();
		UserEntity userEntity = createUserEntity();
		return new Object[][] { { inDto, userEntity } };
	}

	public static UserEntity createUserEntity()
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId("nit140");
		userEntity.setFirstName("ashish");
		userEntity.setLastName("B");
		userEntity.setEmail("ab@gmail.com");
		userEntity.setUserType(UserType.END_USER);

		return userEntity;
	}

	public static UserInputDto createDefaultInputDTForSaveFunction()
	{
		UserInputDto userInputDto = new UserInputDto();
		userInputDto.setUserId("nit0102"); // id should not be present in db
		userInputDto.setFirstName("nik");
		userInputDto.setLastName("jaunjal");
		userInputDto.setEmail("nikhil.jaunjal@gmail.com");
		userInputDto.setUserType(UserType.END_USER);
		return userInputDto;
	}

	public static UserOutDto createDefualtOutDTOForSaveFunction()
	{
		UserOutDto expectedUserOutDto = new UserOutDto();
		expectedUserOutDto.setUserId("nit0102");
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
		userInputDto.setUserType(UserType.END_USER);
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
