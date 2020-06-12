package com.carpco.petcity.view.layout;

import com.carpco.petcity.dto.UserDto;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;

import java.util.Objects;

import static com.carpco.petcity.view.config.AttributeConstants.CLIENT;

public class MainLayout extends VerticalLayout implements RouterLayout, BeforeEnterObserver {
  
  public MainLayout() {
    setSpacing(false);
    setMargin(false);
  }
  
  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    UserDto client = (UserDto) VaadinSession.getCurrent().getAttribute(CLIENT);
    String path = event.getLocation().getPath();
    if (Objects.isNull(client) && !(path.contains("login") || path.contains("signup") || path.contains("password"))) {
      event.forwardTo("login", path);
    }
  }
}
