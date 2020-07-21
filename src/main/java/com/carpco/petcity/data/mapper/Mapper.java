package com.carpco.petcity.data.mapper;

public interface Mapper<E, T> {
  
  T map(E fromObject);
}
