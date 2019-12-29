package com.carpco.petcity.mapper;

public interface Mapper<T, E> {
  
  T toDbo(E dto);
  
  E toDto(T dbo);
}
