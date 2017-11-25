package org.neptune.dto;

import java.util.Date;

public class DeviceInputDto
{
	private String deviceType;
	private String modelNumber;
	private String deviceName;
	private Integer state;
	private Date purchasedDate;
	private String details;

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

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Date getPurchasedDate()
	{
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate)
	{
		this.purchasedDate = purchasedDate;
	}

	public String getDetails()
	{
		return details;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}
}
