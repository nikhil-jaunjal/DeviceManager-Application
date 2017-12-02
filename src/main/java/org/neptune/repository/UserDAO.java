package org.neptune.repository;

import java.util.List;

import org.neptune.enums.UserType;
import org.neptune.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, String>
{
	List<UserEntity> findByFirstNameAndLastNameAndUserType(String firstName, String lastName, UserType type);

	List<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);

	List<UserEntity> findByUserTypeAndLastName(UserType type, String lastName);

	List<UserEntity> findByFirstNameAndUserType(String firstName, UserType type);

	List<UserEntity> findByFirstName(String firstName);

	List<UserEntity> findByLastName(String lastName);

	List<UserEntity> findByUserType(UserType type);
}
