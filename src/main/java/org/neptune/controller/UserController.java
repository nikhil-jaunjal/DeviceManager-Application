package org.neptune.controller;

import java.util.List;

import org.neptune.dto.UserCustomOutDto;
import org.neptune.dto.UserInputDto;
import org.neptune.dto.UserOutDto;
import org.neptune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping
	public UserOutDto save(@RequestBody UserInputDto userInDTO)
	{
		return userService.save(userInDTO);
	}

	@PutMapping("/{id}")
	public UserOutDto update(@RequestBody UserInputDto userInDTO, @PathVariable String id)
	{
		return userService.update(userInDTO, id);
	}

	@DeleteMapping
	public void delete(@RequestParam("id") String id)
	{
		userService.delete(id);
	}

	@GetMapping
	public List<UserOutDto> findUsers(@RequestParam(value = "firstname", required = false) String firstName,
			@RequestParam(value = "lastname", required = false) String lastName,
			@RequestParam(value = "type", required = false) Integer type)
	{
		return userService.findUsers(firstName, lastName, type);
	}

	@GetMapping("/{userId}")
	public UserOutDto findByUserId(@PathVariable String userId)
	{
		return userService.findByUserId(userId);
	}

	@GetMapping(value = "/{userId}/devices")
	public List<UserCustomOutDto> findDevicesOfUser(@PathVariable String userId)
	{
		return userService.findDevicesOfUser(userId);
	}
}
