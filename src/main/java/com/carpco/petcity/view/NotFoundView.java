package com.carpco.petcity.view;

import com.carpco.petcity.view.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.*;

import javax.servlet.http.HttpServletResponse;

@ParentLayout(MainLayout.class)
public class NotFoundView extends Div implements HasErrorParameter<NotFoundException> {
  
  private final Label error = new Label();
  
  public NotFoundView() {
    add(error);
  }
  
  @Override
  public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
    error.setText("Cannot find URL: " + event.getLocation().getPath());
    return HttpServletResponse.SC_NOT_FOUND;
  }
}
