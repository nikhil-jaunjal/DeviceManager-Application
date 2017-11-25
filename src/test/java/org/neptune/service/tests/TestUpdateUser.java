package org.neptune.service.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUpdateUser
{
	@Autowired
	UserService userService;

	@Test()
	public void testUpdateUser()
	{
		UserInputDto testInDto = new UserInputDto();
		testInDto.setUserId("nit085");
		testInDto.setFirstName("update");
		testInDto.setLastName("update");
		testInDto.setEmail("update@gmail.com");
		testInDto.setUserType(2);

		String testInUserId = "nit085";

		UserOutDto expectedOutDto = new UserOutDto();
		expectedOutDto.setUserId("nit085");
		expectedOutDto.setFirstName("update");
		expectedOutDto.setLastName("update");
		expectedOutDto.setEmail("update@gmail.com");
		expectedOutDto.setUserType("DEVICE_ADMIN");

		UserOutDto savedDto = userService.update(testInDto, testInUserId);

		assertEquals(expectedOutDto.getUserId(), savedDto.getUserId());
		assertEquals(expectedOutDto.getFirstName(), savedDto.getFirstName());
		assertEquals(expectedOutDto.getLastName(), savedDto.getLastName());
		assertEquals(expectedOutDto.getEmail(), savedDto.getEmail());
		assertEquals(expectedOutDto.getUserType(), savedDto.getUserType());
	}
}
