package com.ocean.servlet.service;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MyUI extends UI {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {

        final TextField name = new TextField("Name");
        final Button greetButton = new Button("Greet");

        greetButton.addClickListener(
                new Button.ClickListener() {
                    
                    @Override
                    public void buttonClick(ClickEvent event) {
                        // TODO Auto-generated method stub
                        Notification.show("Hi " + name.getValue());
                    }
                }
        );
        setContent(new VerticalLayout(name, greetButton));

    }

}
