package org.neptune.repository;

import java.util.List;

import org.neptune.model.DeviceUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceUsageDAO extends JpaRepository<DeviceUsage, Integer>
{
	public List<DeviceUsage> findByUserUserId(String userId);

	public List<DeviceUsage> findByDeviceDeviceId(Integer deviceId);
}
