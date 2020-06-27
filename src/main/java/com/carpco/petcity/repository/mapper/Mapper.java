package com.carpco.petcity.repository.mapper;

public interface Mapper<T, E> {
  
  T map(E fromObject);
}
