package com.carpco.petcity.dto.mapper;

public interface Mapper<T, E> {
  
  T map(E fromObject);
}
