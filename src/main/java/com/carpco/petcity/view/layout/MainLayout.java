package com.carpco.petcity.view.layout;

import com.carpco.petcity.business.dto.SignUpUser;
import com.carpco.petcity.view.constants.LoginConstants;
import com.carpco.petcity.view.constants.RememberPasswordConstants;
import com.carpco.petcity.view.constants.SignUpConstants;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.VaadinSession;

import java.util.Objects;

import static com.carpco.petcity.view.constants.AttributeConstants.CLIENT;

public class MainLayout extends VerticalLayout implements RouterLayout, BeforeEnterObserver {
  
  public MainLayout() {
    setSpacing(false);
    setMargin(false);
  }
  
  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    SignUpUser client = (SignUpUser) VaadinSession.getCurrent().getAttribute(CLIENT);
    String path = event.getLocation().getPath();
    if (Objects.isNull(client) && !isNotSignedInPage(path)) {
      event.forwardTo(LoginConstants.ROUTE, path);
    }
  }
  
  private boolean isNotSignedInPage(String path) {
    return path.contains(LoginConstants.ROUTE) || path.contains(SignUpConstants.ROUTE) || path.contains(RememberPasswordConstants.ROUTE);
  }
}
