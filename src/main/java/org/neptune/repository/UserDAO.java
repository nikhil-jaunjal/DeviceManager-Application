package org.neptune.repository;

import java.util.List;

import org.neptune.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, String>
{
	List<UserEntity> findByFirstNameAndLastNameAndUserType(String firstName, String lastName, Integer type);

	List<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);

	List<UserEntity> findByUserTypeAndLastName(Integer type, String lastName);

	List<UserEntity> findByFirstNameAndUserType(String firstName, Integer type);

	List<UserEntity> findByFirstName(String firstName);

	List<UserEntity> findByLastName(String lastName);

	List<UserEntity> findByUserType(Integer type);
}
