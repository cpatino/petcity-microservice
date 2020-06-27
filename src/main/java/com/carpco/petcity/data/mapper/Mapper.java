package com.carpco.petcity.data.mapper;

public interface Mapper<T, E> {
  
  T map(E fromObject);
}
