package com.carpco.petcity.business.gateway.impl;

import com.carpco.petcity.business.dto.VaccineDto;
import com.carpco.petcity.business.dto.Veterinary;
import com.carpco.petcity.business.gateway.VaccineGateway;
import com.carpco.petcity.data.mapper.ListMapper;
import com.carpco.petcity.data.mapper.Mapper;
import com.carpco.petcity.data.model.Company;
import com.carpco.petcity.data.model.Vaccine;
import com.carpco.petcity.data.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineGatewayImpl implements VaccineGateway {

  private final VaccineRepository vaccineRepository;

  @Qualifier("company")
  private final Mapper<Veterinary, Company> companyMapper;
  @Qualifier("vaccineList")
  private final ListMapper<Vaccine, VaccineDto> vaccineListMapper;


  public VaccineGatewayImpl(VaccineRepository vaccineRepository, Mapper<Veterinary, Company> companyMapper, ListMapper<Vaccine, VaccineDto> vaccineMapperList) {
    this.vaccineRepository = vaccineRepository;
    this.companyMapper = companyMapper;
    this.vaccineListMapper = vaccineMapperList;
  }

  @Override
  public List<VaccineDto> listVaccine(Veterinary veterinary, boolean enabled) {
    return vaccineListMapper.map(vaccineRepository.findAllByCompanyAndEnabled(companyMapper.map(veterinary), enabled));
  }
}
