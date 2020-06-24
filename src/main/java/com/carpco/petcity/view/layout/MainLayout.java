package com.carpco.petcity.view.layout;

import com.carpco.petcity.constants.LoginConstants;
import com.carpco.petcity.constants.RememberPasswordConstants;
import com.carpco.petcity.constants.SignUpConstants;
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
    if (Objects.isNull(client) && !isNotSignedInPage(path)) {
      event.forwardTo(LoginConstants.ROUTE, path);
    }
  }
  
  private boolean isNotSignedInPage(String path) {
    return path.contains(LoginConstants.ROUTE) || path.contains(SignUpConstants.ROUTE) || path.contains(RememberPasswordConstants.ROUTE);
  }
}
