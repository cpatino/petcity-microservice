package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface NotificationRepository extends JpaRepository<NotificationEntity, BigInteger> {
}
