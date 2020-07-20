package com.carpco.petcity.data.repository;

import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.User;
import com.carpco.petcity.data.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, BigInteger> {

  List<Vaccine> findAllByCompanyAndEnabled(Company company, boolean enabled);

}
