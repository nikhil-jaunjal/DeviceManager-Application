package org.neptune.dto;

import java.util.Date;

public class DeviceUsageDto
{
	private Integer deviceUsageId;
	private Date startDate;
	private Date endDate;
	private String userId;
	private Integer deviceId;

	public Integer getDeviceUsageId()
	{
		return deviceUsageId;
	}

	public void setDeviceUsageId(Integer deviceUsageId)
	{
		this.deviceUsageId = deviceUsageId;
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

}
