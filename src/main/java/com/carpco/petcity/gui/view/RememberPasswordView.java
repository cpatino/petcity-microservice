package com.carpco.petcity.gui.view;

import com.carpco.petcity.gui.view.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.carpco.petcity.gui.constants.RememberPasswordConstants.ROUTE;

@Component
@Scope("prototype")
@Route(value = ROUTE, layout = MainLayout.class)
@PageTitle("Vet Soporte | password")
public class RememberPasswordView extends VerticalLayout {
}
