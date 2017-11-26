package org.neptune.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DeviceUsage")
public class DeviceUsage
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_usage_id")
	private Integer deviceUsageId;

	@Column(name = "usage_start_date")
	private Date startDate;

	@Column(name = "usage_end_date")
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "ref_user_id")
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "ref_device_id")
	private DeviceEntity device;

	public DeviceUsage()
	{

	}

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

	public UserEntity getUser()
	{
		return user;
	}

	public void setUser(UserEntity user)
	{
		this.user = user;
	}

	public DeviceEntity getDevice()
	{
		return device;
	}

	public void setDevice(DeviceEntity device)
	{
		this.device = device;
	}

}
