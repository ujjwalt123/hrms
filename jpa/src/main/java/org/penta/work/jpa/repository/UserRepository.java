package org.penta.work.jpa.repository;

import java.util.UUID;

import org.penta.work.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {

	UserEntity findByEmailAndPassword(String email, String password);
	UserEntity findById(UUID id);
}
