package com.carpco.petcity.mapper;

public interface Mapper<T, E> {
  
  T map(E dto);
}
