package org.neptune.enums;

public enum DeviceState
{
	BRAND_NEW(1, "brand_new"), NOT_IN_USE(2, "not_in_use"), IN_USE(3, "in_use"), E_WASTE(4, "e_waste");

	private Integer key;
	private String value;

	private DeviceState(Integer key, String value)
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

	public static DeviceState getEnumValue(Integer dbData)
	{
		for (DeviceState state : DeviceState.values())
		{
			if (dbData == state.key)
			{
				return state;
			}
		}
		throw new IllegalArgumentException("Unknown Device State : " + dbData);
	}

}
