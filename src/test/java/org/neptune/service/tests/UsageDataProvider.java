package org.neptune.service.tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;

public class UsageDataProvider
{
	public DeviceUsageInputDto createInputDtoForUsage()
	{
		DeviceUsageInputDto deviceUsageInputDto = new DeviceUsageInputDto();
		deviceUsageInputDto.setUserId("nit090");
		deviceUsageInputDto.setDeviceId(1);
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date startDate, endDate;
			startDate = df.parse("2015-04-03");
			endDate = df.parse("2017-04-03");
			deviceUsageInputDto.setStartDate(startDate);
			deviceUsageInputDto.setEndDate(endDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return deviceUsageInputDto;
	}

	public DeviceUsageDto createUpdateDtoForUsage()
	{
		DeviceUsageDto updateDto = new DeviceUsageDto();
		updateDto.setDeviceUsageId(1);
		updateDto.setDeviceId(1);
		updateDto.setUserId("nit090");
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date startDate, endDate;
			startDate = df.parse("2015-04-03");
			endDate = df.parse("2017-04-03");
			updateDto.setStartDate(startDate);
			updateDto.setEndDate(endDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}

		return updateDto;
	}

}
