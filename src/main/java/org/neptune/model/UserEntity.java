package org.neptune.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.neptune.converter.UserTypeEnumConverter;
import org.neptune.enums.UserType;

@Entity
@Table(name = "User")
public class UserEntity
{
	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Convert(converter = UserTypeEnumConverter.class)
	@Column(name = "user_type")
	private UserType userType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<DeviceUsage> deviceUsage;

	public List<DeviceUsage> getDeviceUsage()
	{
		return deviceUsage;
	}

	public void setDeviceUsage(List<DeviceUsage> deviceUsage)
	{
		this.deviceUsage = deviceUsage;
	}

	public UserEntity()
	{

	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public UserType getUserType()
	{
		return userType;
	}

	public void setUserType(UserType userType)
	{
		this.userType = userType;
	}

}
