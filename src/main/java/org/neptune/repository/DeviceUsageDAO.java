package org.neptune.repository;

import java.util.List;

import org.neptune.model.DeviceUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceUsageDAO extends JpaRepository<DeviceUsage, Integer>
{
	public List<DeviceUsage> findByUserUserId(String userId);

	public List<DeviceUsage> findByDeviceDeviceId(Integer deviceId);

	@Query(value = "select * from device_usage  where ref_device_id=?1 and usage_end_date IS NULL", nativeQuery = true)
	public List<DeviceUsage> findDeviceIsInUse(Integer deviceId);
}
