package com.carpco.petcity.adapter.persistence.repository;

import com.carpco.petcity.adapter.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CompanyRepository extends JpaRepository<CompanyEntity, BigInteger> {
}
