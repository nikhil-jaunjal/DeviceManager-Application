package org.neptune.dto;

import java.util.Date;

public class DeviceUsageInputDto
{
	private Date startDate;
	private Date endDate;
	private String userId;
	private Integer deviceId;

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date date)
	{
		this.startDate = date;
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
