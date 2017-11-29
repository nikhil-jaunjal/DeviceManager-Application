package org.neptune.controller;

import org.neptune.dto.DeviceUsageDto;
import org.neptune.dto.DeviceUsageInputDto;
import org.neptune.service.DeviceUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api("usage")
@RestController
@RequestMapping("/usage")
public class DeviceUsageController
{
	@Autowired
	private DeviceUsageService deviceUsageService;

	@PostMapping
	public DeviceUsageDto save(@RequestBody DeviceUsageInputDto deviceUsageDTO)
	{
		return deviceUsageService.save(deviceUsageDTO);
	}

	@PutMapping("/{id}")
	public DeviceUsageDto update(@RequestBody DeviceUsageDto deviceUsageDTO, Integer id)
	{
		return deviceUsageService.update(deviceUsageDTO, id);
	}

	@DeleteMapping
	public void delete(@RequestParam("id") Integer id)
	{
		deviceUsageService.delete(id);
	}
}
