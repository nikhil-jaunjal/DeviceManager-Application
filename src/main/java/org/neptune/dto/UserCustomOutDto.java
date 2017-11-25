package org.neptune.dto;

import java.util.Date;

public class UserCustomOutDto
{
	private String userId;
	
	private Integer deviceId;
	private String deviceType;
	private String modelNumber;
	private String deviceName;
	
	private Date startDate;
	private Date endDate;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public Integer getDeviceId()
	{
		return deviceId;
	}

	public void setDeviceId(Integer deviceId)
	{
		this.deviceId = deviceId;
	}

	public String getDeviceType()
	{
		return deviceType;
	}

	public void setDeviceType(String deviceType)
	{
		this.deviceType = deviceType;
	}

	public String getModelNumber()
	{
		return modelNumber;
	}

	public void setModelNumber(String modelNumber)
	{
		this.modelNumber = modelNumber;
	}

	public String getDeviceName()
	{
		return deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

}
