package org.neptune.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.neptune.enums.DeviceState;

@Converter
public class StateEnumConverter implements AttributeConverter<DeviceState, Integer>
{

	@Override
	public Integer convertToDatabaseColumn(DeviceState attribute)
	{
		return attribute.getKey();
	}

	@Override
	public DeviceState convertToEntityAttribute(Integer dbData)
	{
		return DeviceState.getEnumValue(dbData);
	}

}
