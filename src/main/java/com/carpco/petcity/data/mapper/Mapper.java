package com.carpco.petcity.data.mapper;

import java.util.List;

public interface Mapper<E, T> {
  
  T map(E fromObject);

}
