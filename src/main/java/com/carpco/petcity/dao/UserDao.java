package com.carpco.petcity.dao;

import com.carpco.petcity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserDao extends JpaRepository<User, BigInteger> {
  
  public User findByEmailAndPassword(String email, String password);
}
