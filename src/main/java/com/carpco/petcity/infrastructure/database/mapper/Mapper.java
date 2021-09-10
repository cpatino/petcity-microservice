package com.carpco.petcity.infrastructure.database.mapper;

public interface Mapper<E, T> {
  
  T map(E fromObject);
}
