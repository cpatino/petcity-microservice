package com.carpco.petcity.repository;

import com.carpco.petcity.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
  
  Optional<User> findByEmailAndPassword(String email, String password);
}
