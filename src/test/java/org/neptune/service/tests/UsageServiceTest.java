package org.neptune.service.tests;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.InvalidDateException;
import org.neptune.exception.InvalidDeviceIdException;
import org.neptune.exception.InvalidDeviceUsageIdException;
import org.neptune.exception.InvalidUserIdException;
import org.neptune.exception.UsageNotFoundException;
import org.neptune.model.DeviceEntity;
import org.neptune.model.UserEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.repository.DeviceUsageDAO;
import org.neptune.repository.UserDAO;
import org.neptune.service.DeviceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsageServiceTest
{
	@Autowired
	private DeviceUsageDAO deviceUsageRepo;

	@Autowired
	private UserDAO userRepo;
	@Autowired
	private DeviceDAO deviceRepo;

	@Autowired
	private DeviceUsageService usageService;

	// ------- negative tests for save() ----------
	@Test
	public void save_InvalidUserIdException_Test()
	{
		UsageDataProvider dataProvider = new UsageDataProvider();
		DeviceUsageInputDto inputDto = dataProvider.createInputDtoForUsage();
		inputDto.setUserId("*nit*90");
		try
		{
			usageService.save(inputDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else
			{
				fail("Test Fail! - Valid UserId" + e.toString());
			}
		}
	}

	@Test
	public void save_InvalidDeviceIdException()
	{
		UsageDataProvider dataProvider = new UsageDataProvider();
		DeviceUsageInputDto inputDto = dataProvider.createInputDtoForUsage();
		inputDto.setDeviceId(404);
		try
		{
			usageService.save(inputDto);
		} catch (Exception e)
		{
			if (e instanceof DataNotFoundException)
			{
			} else
			{
				fail("Test Fail! - Valid UserId" + e.toString());
			}
		}
	}

	@Test
	public void save_InvalidDateException_Test()
	{
		UsageDataProvider dataProvider = new UsageDataProvider();
		DeviceUsageInputDto inputDto = dataProvider.createInputDtoForUsage();
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date startDate, endDate;
			startDate = df.parse("2020-04-03");
			endDate = df.parse("2017-04-03");
			inputDto.setStartDate(startDate);
			inputDto.setStartDate(endDate);
			usageService.save(inputDto);
		} catch (Exception e)
		{
			if (e instanceof InvalidDateException)
			{
			} else if (e instanceof DataNotFoundException)
			{
				fail("Test Failed! - userId or deviceId is not present in db, both must be present in db to pass this test");
			} else
			{
				fail("Test Failed! - dates are entered sequentially or other exception occoured" + e.toString());
			}
		}
	}

	@Test
	public void save_EmptyEntity_Test()
	{
		UserEntity userEntity = userRepo.findOne("");
		DeviceEntity deviceEntity = deviceRepo.findOne(404);
		if (userEntity == null || deviceEntity == null)
		{
		} else
		{
			fail("Test Failed! - userId or deviceId is present in database");
		}
	}

	// -------- negative tests for update() -----------

	@Test
	public void update_DataNotFoundExceptionForUsageId_Test()
	{
		try
		{
			deviceUsageRepo.findOne(404);
		} catch (Exception e)
		{
			if (e instanceof UsageNotFoundException)
			{
			} else
			{
				fail("Test Failed! - usage Id is present in database");
			}
		}
	}

	@Test
	public void update_InvalidUserIdException_Test()
	{
		UsageDataProvider dataProvider = new UsageDataProvider();
		DeviceUsageDto deviceUsageDto = dataProvider.createUpdateDtoForUsage();
		deviceUsageDto.setUserId("");
		try
		{
			usageService.update(deviceUsageDto, deviceUsageDto.getDeviceUsageId());
		} catch (Exception e)
		{
			if (e instanceof InvalidUserIdException)
			{
			} else
			{
				fail("Test Failed! - valid userId given");
			}
		}
	}

	@Test
	public void update_InvalidDeviceIdExeption_Test()
	{
		UsageDataProvider dataProvider = new UsageDataProvider();
		DeviceUsageDto deviceUsageDto = dataProvider.createUpdateDtoForUsage();
		try
		{
			usageService.update(deviceUsageDto, deviceUsageDto.getDeviceUsageId());
			deviceUsageDto.setDeviceId(-15);
		} catch (Exception e)
		{
			if (e instanceof InvalidDeviceIdException)
			{
			} else
			{
				fail("Test Failed! - valid deviceId given");
			}
		}
	}

	@Test
	public void update_EntityEmpty_Test()
	{
		try
		{
			userRepo.findOne("nit404");
			deviceRepo.findOne(404);
		} catch (Exception e)
		{
			if (e instanceof DataNotFoundException)
			{
			} else
			{
				fail("Test Failed! - entities arer not empty" + e.toString());
			}
		}
	}

	@Test
	public void delete_InvalidUsageIdException_Test()
	{
		try
		{
			usageService.delete(-15);
		} catch (Exception e)
		{
			if (e instanceof InvalidDeviceUsageIdException)
			{
			} else
			{
				fail("test failed! - valid usageId given" + e.toString());
			}
		}
	}

	@Test
	public void delete_EmptyEntiy_Test()
	{
		try
		{
			deviceUsageRepo.findOne(404);
		} catch (Exception e)
		{
			if (e instanceof DataNotFoundException)
			{
			} else
			{
				fail("Test Failed! - usageId present in database");
			}
		}
	}
}
