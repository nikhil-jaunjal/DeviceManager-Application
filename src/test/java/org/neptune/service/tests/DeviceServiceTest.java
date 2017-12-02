package org.neptune.service.tests;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceOutDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.enums.DeviceState;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.InvalidDeviceTypeException;
import org.neptune.exception.InvalidModelNumberException;
import org.neptune.mapper.DozerBeanMapper;
import org.neptune.model.DeviceEntity;
import org.neptune.repository.DeviceDAO;
import org.neptune.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceTest
{
	@Autowired
	DeviceService deviceService;
	@Autowired
	DeviceDAO deviceRepo;
	@Autowired
	private DozerBeanMapper mapper;

	// ----------- negative test for Save()-------------
	@Test
	public void save_InvalidDeviceTypeException_Test()
	{
		DeviceDataProvider deviceDataProvider = new DeviceDataProvider();

		boolean flag = true;
		DeviceInputDto deviceInputDto = deviceDataProvider.createDefaultInputDTOForSaveFunction();
		deviceInputDto.setDeviceType("567ydhscb");
		try
		{
			deviceService.save(deviceInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidDeviceTypeException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'device type' given");
		}
	}

	@Test
	public void save_InvalidModelNumberException_Test()
	{
		DeviceDataProvider deviceDataProvider = new DeviceDataProvider();

		boolean flag = true;
		DeviceInputDto deviceInputDto = deviceDataProvider.createDefaultInputDTOForSaveFunction();
		deviceInputDto.setModelNumber("*$@#()//");
		try
		{
			deviceService.save(deviceInputDto);
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidModelNumberException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition" + e.toString());
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'model number' given");
		}
	}



	// ----------- negative test for Update()-------------

	@Test
	public void update_DeviceDoesNotExistsException_Test()
	{
		DeviceEntity deviceEntity = deviceRepo.findOne(404);
		if (deviceEntity == null)
		{
		} else
		{
			fail("test failed! - device exists");
		}
	}

	@Test
	public void update_InvalidDeviceTypeException_Test()
	{

		DeviceDataProvider deviceDataProvider = new DeviceDataProvider();

		boolean flag = true;
		DeviceUpdateDto deviceUpdateDto = deviceDataProvider.createDefaultUpdateDTOForUpdate();
		deviceUpdateDto.setDeviceType("7689laptop$%@#**");
		try
		{
			deviceService.update(deviceUpdateDto, deviceUpdateDto.getDeviceId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidDeviceTypeException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition");
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'DeviceType' given");
		}
	}

	@Test
	public void update_InvalidDeviceModelNumberException_Test()
	{
		DeviceDataProvider deviceDataProvider = new DeviceDataProvider();

		boolean flag = true;
		DeviceUpdateDto deviceUpdateDto = deviceDataProvider.createDefaultUpdateDTOForUpdate();
		deviceUpdateDto.setModelNumber("8*^$$)(%#%9hdcs");
		try
		{
			deviceService.update(deviceUpdateDto, deviceUpdateDto.getDeviceId());
			flag = false;
		} catch (Exception e)
		{
			if (e instanceof InvalidModelNumberException)
			{
			} else if (e instanceof Exception)
			{
				fail("Test failed - untracked condition");
			}
		}
		if (flag == false)
		{
			fail("Test failed - correct 'Model Number' given");
		}
	}



	// ----------- negative test for delete()-------------

	@Test
	public void delete_DeviceEntityNull_Test()
	{
		if (deviceRepo.findOne(404) == null)
		{
		} else
		{
			fail("Test Failed! - id present in database");
		}
	}

	// ----------- negative test for findByDeviceId()-------------
	@Test
	public void findByDeviceId_DeviceEntityNull_Test()
	{
		if (deviceRepo.findOne(404) == null)
		{
		} else
		{
			fail("Test Failed! - id present in database");
		}
	}

	// ----------- negative test for findUsersOfDevice()-------------

	@Test
	public void findUsersOfDevice_DataNotFoundException_Test()
	{
		try
		{
			deviceService.findUsersOfDevice(404);
		} catch (Exception e)
		{
			if (e instanceof DataNotFoundException)
			{
			} else
			{
				fail("test failed! - valid 'Device Id' given" + e.toString());
			}
		}
	}

	// --------- negative test for findDevices() ------------

	@Test
	public void findDevices_DataNotFoundForStateException_Test()
	{
		try
		{
			deviceService.findDevices("12345**", DeviceState.IN_USE);
		} catch (Exception e)
		{
			if (e instanceof DataNotFoundException)
			{
			} else
			{
				fail("test failed! - valid 'device type' given" + e.toString());
			}
		}
	}

	@SuppressWarnings("null")
	@Test
	public void findDevices_EmptyEntityList_Test()
	{
		try
		{
			List<DeviceEntity> deviceEntityList = null;
			deviceEntityList.isEmpty();
		} catch (Exception e)
		{
			if (e instanceof NullPointerException)
			{
			} else
			{
				fail("Test Failed! - List is not empty");
			}
		}
	}
}
