package org.neptune.service.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.enums.DeviceState;

public class DeviceDataProvider
{
	public DeviceInputDto createDefaultInputDTOForSaveFunction()
	{
		DeviceInputDto deviceInDto = new DeviceInputDto();
		deviceInDto.setDeviceType("Laptop");
		deviceInDto.setDeviceName("MacBook Pro");
		deviceInDto.setModelNumber("MBP2015JUN25");
		deviceInDto.setDetails("working");
		deviceInDto.setState(DeviceState.IN_USE);
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date;
			date = df.parse("2015-04-03");
			deviceInDto.setPurchasedDate(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return deviceInDto;
	}

	public DeviceUpdateDto createDefaultUpdateDTOForUpdate()
	{
		DeviceUpdateDto updateDto = new DeviceUpdateDto();
		updateDto.setDeviceId(1);
		updateDto.setDetails("details");
		updateDto.setDeviceName("abcd");
		updateDto.setDeviceType("abcd");
		updateDto.setModelNumber("68LKMNJF09");
		updateDto.setState(DeviceState.BRAND_NEW);
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date;
			date = df.parse("2015-04-03");
			updateDto.setPurchasedDate(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return updateDto;
	}
}
