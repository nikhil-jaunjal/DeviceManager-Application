package org.neptune.service.tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.exception.InvalidEmailIdException;
import org.neptune.exception.InvalidFirstNameException;
import org.neptune.exception.InvalidLastNameException;
import org.neptune.exception.InvalidUserIdException;
import org.neptune.exception.InvalidUserTypeException;
import org.neptune.mapper.DozerBeanMapper;
import org.neptune.model.DeviceUsage;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceUsageDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest
{

	@Autowired
	UserDAO userDao;

	@Autowired
	private DeviceUsageDAO userDeviceDao;

	@Autowired
	UserService userService;

	@Autowired
	private DozerBeanMapper mapper;

	// ---------------------positive test for save()--------------------------

	// @Test()
	// public void testSaveUser()
	// {
	// UserDataProvider userDataProvider = new UserDataProvider();
	//
	// UserOutDto savedDto =
	// userService.save(userDataProvider.createDefaultInputDTO());
	//
	// assertEquals(userDataProvider.createDefualtOutDTO().getUserId(),
	// savedDto.getUserId());
	// assertEquals(userDataProvider.createDefualtOutDTO().getFirstName(),
	// savedDto.getFirstName());
	// assertEquals(userDataProvider.createDefualtOutDTO().getLastName(),
	// savedDto.getLastName());
	// assertEquals(userDataProvider.createDefualtOutDTO().getEmail(),
	// savedDto.getEmail());
	// assertEquals(userDataProvider.createDefualtOutDTO().getUserType(),
	// savedDto.getUserType());
	// }

	// --------------------negative tests for save()----------

	@Test
	public void saveUser_InvalidUserId_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		userInputDto.setUserId("67n*it124");
		try
		{
			userService.save(userInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition or 'userId' already exists" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'UserId' given");
		}
	}

	@Test
	public void saveUser_InvalidFirstName_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		userInputDto.setFirstName("6nnit124");
		try
		{
			userService.save(userInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidFirstNameException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'FirstName' given");
		}
	}

	@Test
	public void saveUser_InvalidLastName_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		userInputDto.setLastName("6nnit124");
		try
		{
			userService.save(userInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidLastNameException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'LastName' given");
		}
	}

	@Test
	public void saveUser_InvalidEmailId_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		userInputDto.setEmail("6nnit124");
		try
		{
			userService.save(userInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidEmailIdException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'Email Id' given");
		}
	}

	@Test
	public void saveUser_InvalidUserType_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		userInputDto.setUserType(-33);
		try
		{
			userService.save(userInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidUserTypeException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'User Type' given");
		}
	}

	@Test
	public void saveUser_UserAlreadyExistsException_Test()
	{
		UserEntity userEntity = userDao.findOne("nit9108067");
		if (userEntity != null)
		{
			fail("UserAlreadyExistsTest failed!");
		}
	}

	@Test
	public void saveUser_setUserType_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForSaveFunction();
		UserEntity userEntity = mapper.map(userInputDto, UserEntity.class);
		userDao.save(userEntity);
		UserOutDto userOutDto = mapper.map(userEntity, UserOutDto.class);
		userOutDto.setUserType(userService.setEnumValueOfKey(50));//

		if (userOutDto.getUserType().equals(""))
		{
		} else
		{
			fail("Test Failed - correct userType given to test");
		}
	}

	// ------------- positive test for Update() ---------------------

	// @Test()
	// public void updateUser_Test()
	// {
	// UserDataProvider userDataProvider = new UserDataProvider();
	//
	// UserOutDto updateDto
	// =userService.update(userDataProvider.createDefaultInputDTForUpdateFunction(),userDataProvider.createDefaultInputDTForSaveFunction().getUserId());
	//
	// assertEquals(userDataProvider.createDefualtOutDTOUpdateFunction().getUserId(),updateDto.getUserId());
	// assertEquals(userDataProvider.createDefualtOutDTOUpdateFunction().getFirstName(),updateDto.getFirstName());
	// assertEquals(userDataProvider.createDefualtOutDTOUpdateFunction().getLastName(),updateDto.getLastName());
	// assertEquals(userDataProvider.createDefualtOutDTOUpdateFunction().getEmail(),updateDto.getEmail());
	// assertEquals(userDataProvider.createDefualtOutDTOUpdateFunction().getUserType(),updateDto.getUserType());
	// }

	// ------------------negative tests for update()-----------------------
	@Test
	public void updateUser_UserDoesNotExistsException_Test()
	{
		UserEntity userEntity = userDao.findOne("nit9108067");
		if (userEntity == null)
		{
		} else
		{
			fail("UserDoesNotExistsExceptionTest failed!");
		}
	}

	@Test
	public void updateUser_InvalidUserId_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		userInputDto.setUserId("12nik");
		try
		{
			userService.update(userInputDto, "nit091"); // nit091 should be present in db else test will always fail
														// with untracked condition.
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'UserId' given");
		}
	}

	@Test
	public void updateUser_InvalidFirstName_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		userInputDto.setFirstName("12nik");
		try
		{
			userService.update(userInputDto, userInputDto.getUserId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidFirstNameException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'FirstName' given");
		}
	}

	@Test
	public void updateUser_InvalidLastName_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		userInputDto.setLastName("nik$*1");
		try
		{
			userService.update(userInputDto, userInputDto.getUserId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidLastNameException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'LastName' given");
		}
	}

	@Test
	public void updateUser_InvalidEmailId_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		userInputDto.setEmail("nik$*1@abcd");
		try
		{
			userService.update(userInputDto, userInputDto.getUserId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidEmailIdException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'emailId' given");
		}
	}

	@Test
	public void updateUser_InvalidUserType_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();

		boolean flag = true;
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		userInputDto.setUserType(404);
		try
		{
			userService.update(userInputDto, userInputDto.getUserId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidUserTypeException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'UserType' given");
		}
	}

	@Test
	public void updateUser_setUserType_Test()
	{
		UserDataProvider userDataProvider = new UserDataProvider();
		UserInputDto userInputDto = userDataProvider.createDefaultInputDTForUpdateFunction();
		UserEntity userEntity = mapper.map(userInputDto, UserEntity.class);
		userDao.save(userEntity);
		UserOutDto userOutDto = mapper.map(userEntity, UserOutDto.class);
		userOutDto.setUserType(userService.setEnumValueOfKey(404));//
		if (userOutDto.getUserType().equals(""))
		{
		} else
		{
			fail("Test Failed - correct userType given to test");
		}
	}

	// ------------- positive test for Delete() ---------------------
	// @Test
	// public void deleteUser_Test()
	// {
	// userRepo.delete("nit099");// id must be present in db
	// UserEntity userEntity = userRepo.findOne("nit099");
	// if (userEntity == null)
	// {
	// } else
	// {
	// fail("Test fail!");
	// }
	//
	// }

	// ------------- negative test for Delete() ---------------------
	@Test
	public void deleteUser_InvalidUserId_Test()
	{
		boolean flag = true;
		try
		{
			userService.delete("**nit09");
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition or 'UserId' does not exits in database table" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'UserId' given");
		}
	}

	@Test
	public void deleteUser_UserNotExistsException_Test()
	{
		UserEntity userEntity = userDao.findOne("nit9108067");
		if (userEntity == null)
		{
		} else
		{
			fail("UserDoesNotExistsExceptionTest failed!");
		}
	}

	// ------------- negative test for findUsers() ---------------------
	@Test
	public void findUsers_InvalidFirstName_Test()
	{
		try
		{
			userService.findUsers("12rfrv", "lastName", 3);
		} catch (Exception e)
		{
			if (e instanceof InvalidFirstNameException)
			{
			} else
			{
				fail("test failed! - valid 'FirstName' given" + e.toString());
			}
		}

	}

	@Test
	public void findUsers_InvalidLastName_Test()
	{
		try
		{
			userService.findUsers("firstName", "12*Name*&4", 3);
		} catch (Exception e)
		{
			if (e instanceof InvalidLastNameException)
			{
			} else
			{
				fail("test failed! - valid 'LastName' given" + e.toString());
			}
		}

	}

	@Test
	public void findUsers_InvalidUserType_Test()
	{
		try
		{
			userService.findUsers("firstName", "lastname", 404);
		} catch (Exception e)
		{
			if (e instanceof InvalidUserTypeException)
			{
			} else
			{
				fail("test failed! - valid 'UserType' given" + e.toString());
			}
		}

	}

	@Test
	public void findUsers_SetUserType_Test()
	{
		try
		{
			UserDataProvider userDataProvider = new UserDataProvider();
			UserOutDto userOutDto = userDataProvider.outDtoForFindUsers();
			userOutDto.setUserType(userService.setEnumValueOfKey(404));
		} catch (Exception e)
		{
			if (e instanceof InvalidUserTypeException)
			{
			} else
			{
				fail("Test Failed ! - valid userType given" + e.toString());
			}
		}
	}

	// ---------negative test for findByUserId()------------

	@Test
	public void findByUserId_InvalidUserId_Test()
	{
		try
		{
			userService.findByUserId("2398");
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else
			{
				fail("test failed! - valid 'UserId' given" + e.toString());
			}
		}

	}

	@Test
	public void findByUserId_UserEntityNull_Test()
	{
		UserEntity userEntity = userDao.findOne("nit404");// id should not be present in db
		if (userEntity == null)
		{
		} else
		{
			fail("Test Failed! - user entity is not null");
		}
	}

	// ---------- negative test for findDevicesOfUser()--------

	@Test
	public void findDevicesOfUser_InvalidUserID_Test()
	{
		try
		{
			userService.findDevicesOfUser("$23nit089");
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else
			{
				fail("test failed! - valid 'UserId' given" + e.toString());
			}
		}
	}

	@Test
	public void findDevicesOfUser_DataNotFoundException_Test()
	{
		List<DeviceUsage> deviceUsageList = userDeviceDao.findByUserUserId("nit404"); // id must not be in db
		if (deviceUsageList.isEmpty())
		{
		} else
		{
			fail("Test Failed! - data for given userId present in db");
		}
	}
}
