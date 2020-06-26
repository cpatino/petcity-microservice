package com.carpco.petcity.business.dto.mapper;

public interface Mapper<T, E> {
  
  T map(E fromObject);
}
