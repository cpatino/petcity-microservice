package com.carpco.petcity.view;

import com.carpco.petcity.dto.SignUpUser;
import com.carpco.petcity.view.layout.MainLayout;
import com.carpco.petcity.view.service.SessionService;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Route(value = "", layout = MainLayout.class)
@PageTitle("Vet Soporte | dashboard")
public class MainView extends Div {
  
  public MainView(SessionService sessionService) {
    add(new H4("Welcome " + sessionService.getSessionUser().map(SignUpUser::getFullName).orElse("") + "!"));
  }
}
