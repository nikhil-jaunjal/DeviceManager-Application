package org.neptune.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.neptune.enums.UserType;

@Converter
public class UserTypeEnumConverter implements AttributeConverter<UserType, Integer>
{

	@Override
	public Integer convertToDatabaseColumn(UserType attribute)
	{
		return attribute.getKey();
	}

	@Override
	public UserType convertToEntityAttribute(Integer dbData)
	{
		return UserType.getEnumValue(dbData);
	}

}
