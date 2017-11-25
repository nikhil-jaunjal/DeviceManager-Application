package org.neptune.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Device")
public class DeviceEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "device_id")
	private Integer deviceId;
	@Column(name = "device_type")
	private String deviceType;
	@Column(name = "model")
	private String modelNumber;
	@Column(name = "device_name")
	private String deviceName;
	@Column(name = "state")
	private Integer state;
	@Column(name = "purchased_date")
	private Date purchasedDate;
	@Column(name = "details")
	private String details;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
	private List<DeviceUsage> deviceUsage;

	public List<DeviceUsage> getDeviceUsage()
	{
		return deviceUsage;
	}

	public void setDeviceUsage(List<DeviceUsage> deviceUsage)
	{
		this.deviceUsage = deviceUsage;
	}

	public DeviceEntity()
	{

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
