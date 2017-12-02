package org.neptune.service.tests;

import static org.mockito.Mockito.when;
import static org.testng.Assert.fail;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.neptune.dto.UserInputDto;
import org.neptune.exception.InvalidEmailIdException;
import org.neptune.exception.InvalidFirstNameException;
import org.neptune.exception.InvalidLastNameException;
import org.neptune.exception.InvalidUserIdException;
import org.neptune.exception.UserAlreadyExistsException;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.UserService;
import org.neptune.validator.UserDtoValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@RunWith(MockitoJUnitRunner.class)
public class TestNGDemo
{
	@Mock
	DeviceDAO deviceDao;

	@Mock
	UserDAO userDao;

	@Spy
	UserDtoValidator validator;

	@InjectMocks
	UserService userService;

	@BeforeMethod
	public void initMocks()
	{
		UserService userService = new UserService();
		MockitoAnnotations.initMocks(this);
	}

	@Test(dataProvider = "dataProviderMethod1", dataProviderClass = UserDataProvider.class)
	public void save_invalidUserId_Test(UserInputDto userInDto)
	{
		userInDto.setUserId("*nit$$$");
		try
		{
			userService.save(userInDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else
			{
				fail("Test Failed !" + e.toString());
			}
		}
	}

	@Test(dataProvider = "dataProviderMethod1", dataProviderClass = UserDataProvider.class)
	public void save_invalidFirstName_Test(UserInputDto userInDto)
	{
		userInDto.setFirstName("-7982@nikhil");
		try
		{
			userService.save(userInDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidFirstNameException)
			{
			} else
			{
				fail("Test Failed !" + e.toString());
			}
		}
	}

	@Test(dataProvider = "dataProviderMethod1", dataProviderClass = UserDataProvider.class)
	public void save_invalidLastName_Test(UserInputDto userInDto)
	{
		userInDto.setLastName("-7982@nikhil");
		try
		{
			userService.save(userInDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidLastNameException)
			{
			} else
			{
				fail("Test Failed !" + e.toString());
			}
		}
	}

	@Test(dataProvider = "dataProviderMethod1", dataProviderClass = UserDataProvider.class)
	public void save_invalidEmail_Test(UserInputDto userInDto)
	{
		userInDto.setEmail("abhit.in");
		try
		{
			userService.save(userInDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidEmailIdException)
			{
			} else
			{
				fail("Test Failed !" + e.toString());
			}
		}
	}

	@Test(dataProvider = "dataProviderMethod2", dataProviderClass = UserDataProvider.class)
	public void save_UserAlreadyExistsException_Test(UserInputDto userInDto, UserEntity userEntity)
	{
		when(userDao.findOne(userInDto.getUserId())).thenReturn(userEntity);
		try
		{
			userService.save(userInDto);
		} catch (Exception e)
		{
			if (e instanceof UserAlreadyExistsException)
			{
			} else
			{
				fail("Test Failed !" + e.toString());
			}
		}
	}
}
