package org.neptune.controller;

import java.util.List;

import org.neptune.dto.DeviceCustomOutDto;
import org.neptune.dto.DeviceInputDto;
import org.neptune.dto.DeviceOutDto;
import org.neptune.dto.DeviceUpdateDto;
import org.neptune.service.DeviceService;
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

import io.swagger.annotations.Api;

@Api("device")
@RestController
@RequestMapping("/devices")
public class DeviceController
{
	@Autowired
	private DeviceService deviceService;

	@PostMapping
	public DeviceOutDto saveDevice(@RequestBody DeviceInputDto deviceInDTO)
	{
		return deviceService.save(deviceInDTO);
	}

	@PutMapping("/{id}")
	public DeviceOutDto updateDevice(@RequestBody DeviceUpdateDto deviceUpdateDto, @PathVariable Integer id)
	{
		return deviceService.update(deviceUpdateDto, id);
	}

	@DeleteMapping
	public void deleteDevice(@RequestParam("id") Integer id)
	{
		deviceService.delete(id);
	}

	@GetMapping("/{id}")
	public DeviceOutDto findByDeviceId(@PathVariable Integer id)
	{
		return deviceService.findByDeviceId(id);
	}

	@GetMapping
	public List<DeviceOutDto> findDevices(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "state", required = false) Integer state)
	{
		return deviceService.findDevices(type, state);
	}

	@GetMapping("/{id}/users")
	public List<DeviceCustomOutDto> findUsersByDeviceId(@PathVariable Integer id)
	{
		return deviceService.findUsersOfDevice(id);
	}

}
