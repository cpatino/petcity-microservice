package com.carpco.petcity.view.account;

import com.carpco.petcity.view.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Route(value = "signup", layout = MainLayout.class)
@PageTitle("Vet Soporte | signup")
public class SignUpView extends VerticalLayout {
}
