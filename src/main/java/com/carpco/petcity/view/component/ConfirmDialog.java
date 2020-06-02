package com.carpco.petcity.view.component;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class ConfirmDialog {
  
  public void show(String message) {
    Dialog dialog = buildDialog();
    VerticalLayout verticalLayout = new VerticalLayout();
    verticalLayout.add(new Label(message), new NativeButton("Cerrar", event -> dialog.close()));
    dialog.add(verticalLayout);
    dialog.open();
  }
  
  private Dialog buildDialog() {
    Dialog dialog = new Dialog();
    dialog.setCloseOnEsc(false);
    dialog.setCloseOnOutsideClick(false);
    return dialog;
  }
}
