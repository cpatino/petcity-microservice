package com.carpco.petcity.service.impl;

import com.carpco.petcity.dto.UserDto;
import com.carpco.petcity.service.SessionService;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.carpco.petcity.view.constants.AttributeConstants.CLIENT;

@Service
public class VaadinSessionServiceImpl implements SessionService {
  
  @Override
  public Optional<UserDto> getSessionUser() {
    return Optional.of(VaadinSession.getCurrent())
      .map(session -> session.getAttribute(CLIENT))
      .map(UserDto.class::cast);
  }
  
  @Override
  public void registerSessionUser(UserDto userDto) {
    VaadinSession.getCurrent().setAttribute(CLIENT, userDto);
  }
}
