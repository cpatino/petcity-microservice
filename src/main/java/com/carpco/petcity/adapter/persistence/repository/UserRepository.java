package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
