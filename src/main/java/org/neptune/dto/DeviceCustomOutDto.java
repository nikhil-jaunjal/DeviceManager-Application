package org.neptune.dto;

import java.util.Date;

public class DeviceCustomOutDto
{
	private Integer deviceId;
	private String deviceType;
	private String modelNumber;

	private String userId;
	private String email;
	private String firstName;
	private String lastName;

	private Date startDate;
	private Date endDate;
	
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
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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
