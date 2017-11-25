package org.neptune.validator;

import java.util.List;

import org.neptune.dto.UserInputDto;
import org.neptune.exception.DataNotFoundException;
import org.neptune.exception.InvalidEmailIdException;
import org.neptune.exception.InvalidFirstNameException;
import org.neptune.exception.InvalidLastNameException;
import org.neptune.exception.InvalidUserIdException;
import org.neptune.exception.InvalidUserTypeException;
import org.neptune.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDtoValidator
{

	public void validate(UserInputDto userInDto)
	{
		checkUserId(userInDto.getUserId());
		checkFirstName(userInDto.getFirstName());
		checkLastName(userInDto.getLastName());
		checkEmail(userInDto.getEmail());
		checkUserType(userInDto.getUserType());
	}

	public void checkUserType(Integer userType)
	{
		if (!(userType == 1 || userType == 2 || userType == 3))
		{
			throw new InvalidUserTypeException();
		}
	}

	public void checkEmail(String email)
	{
		if (!(email.matches("[a-z0-9]+[_a-z0-9\\.-]*[a-z0-9]+@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})")))
		{
			throw new InvalidEmailIdException();
		}
	}

	public void checkFirstName(String firstName)
	{
		if (!firstName.matches("[A-Za-z]+"))
		{
			throw new InvalidFirstNameException();
		}
	}

	public void checkLastName(String lastName)
	{
		if (!lastName.matches("[A-Za-z]+"))
		{
			throw new InvalidLastNameException();
		}
	}

	public void checkUserId(String userId)
	{
		if (!(userId.matches("nit[0-9]+")))
		{
			throw new InvalidUserIdException();
		}
	}

	public void isEmptyEntity(UserEntity userEntity)
	{
		if (userEntity == null)
		{
			throw new DataNotFoundException();
		}
	}

	public void isEmptyEntityList(List<?> entityList)
	{
		if (entityList.isEmpty())
		{
			throw new DataNotFoundException();
		}
	}

}
