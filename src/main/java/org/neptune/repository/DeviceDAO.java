package org.neptune.repository;

import java.util.List;

import org.neptune.enums.DeviceState;
import org.neptune.model.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceDAO extends JpaRepository<DeviceEntity, Integer>
{
	List<DeviceEntity> findByState(DeviceState state);

	List<DeviceEntity> findByDeviceType(String type);

	List<DeviceEntity> findByDeviceTypeAndState(String type, DeviceState state);
}
