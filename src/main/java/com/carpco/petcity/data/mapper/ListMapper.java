package com.carpco.petcity.data.mapper;

import java.util.List;

public interface ListMapper<E, T> {

    List<T> map(List<E> fromList);
}