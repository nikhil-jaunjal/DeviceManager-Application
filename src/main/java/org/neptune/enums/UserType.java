package org.neptune.enums;

public enum UserType
{
	GLOBAL_ADMIN(1, "GLOBAL_ADMIN"), DEVICE_ADMIN(2, "DEVICE_ADMIN"), END_USER(3, "END_USER");

	private Integer key;
	private String value;

	private UserType(Integer key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public Integer getKey()
	{
		return key;
	}

	public String getValue()
	{
		return value;
	}

	public static UserType getEnumValue(Integer dbData)
	{
		for (UserType type : UserType.values())
		{
			if (dbData == type.key)
			{
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown User Type : " + dbData);
	}

}
