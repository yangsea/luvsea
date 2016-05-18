package com.ocean.frame.main.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocean.frame.main.entity.Person;
import com.ocean.frame.main.form.PersonForm;
import com.ocean.frame.main.service.MyUI;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class TestServlet extends HttpServlet{

   /**
     * 
     */
    private static final long serialVersionUID = 1L;

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
       
//       writer  resp.getWriter();
    
//        super.doPost(req, resp);
    System.out.println("this is servlet application");
    } 

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        super.doGet(req, resp);
    System.out.println("this is doget method");
//    super.doPost(req, resp);
//    PersonForm form = new PersonForm();
//    Person p  = new Person();
//    BeanFieldGroup.bindFieldsUnbuffered(p, form);
    

//
// // All of this code is running in your server's JVM
// // Create a TextField input.
// TextField name = new TextField("Your Name", "Vaadin");
//
// // Access any server-side API directly.
//// String serverName = servletContext.getServerInfo();
// String serverName = "serverName";
//
// // Create a Button and define a server-side click listener.
// Button greetButton = new Button("Greet the Server");
// greetButton.addClickListener(event ->   Notification.show("Hello " + name.getValue() + "!\n" +
//                       "I'm " + serverName));
//
// // Display TextField and Button vertically.
// VerticalLayout layout = new VerticalLayout(name, greetButton);
    
//    Notification.show("This is the caption",
//            "This is the description",
//            Notification.Type.WARNING_MESSAGE);
    
//    Notification notif = new Notification(
//            "Warning",
//            "<br/>Area of reindeer husbandry",
//            Notification.TYPE_WARNING_MESSAGE);
//
//        // Customize it
//        notif.setDelayMsec(20000);
//        notif.setPosition(Position.BOTTOM_RIGHT);
//        notif.setStyleName("mystyle");
//        notif.setIcon(new ThemeResource("img/reindeer.png"));
//
//        // Show it in the page
//        notif.show(Page.getCurrent());
    
//    MyUI mu = new MyUI();
//    VaadinRequest request = null;
//    mu.init(request);
    
 // List of entities from any Java backend (EJB/JPA/Spring/etc)
//    List<Person> personList = new ArrayList<Person>();
//    Person person = new Person();
//    person.setFirstName("ocean");
//    personList.add(person);
//
//    // Create a Grid and bind the Person objects to it
//    Grid grid = new Grid();
//    grid.setContainerDataSource(
//        new BeanItemContainer<Person>(Person.class, personList));
//
//    // Define the columns to be displayed
//    grid.setColumns("firstName", "lastName", "email");
    
 // Create a 4 by 4 grid layout.
    GridLayout grid = new GridLayout(4, 4);
    grid.addStyleName("example-gridlayout");

    // Fill out the first row using the cursor.
    grid.addComponent(new Button("R/C 1"));
    for (int i = 0; i < 3; i++) {
        grid.addComponent(new Button("Col " + (grid.getCursorX() + 1)));
    }

    // Fill out the first column using coordinates.
    for (int i = 1; i < 4; i++) {
        grid.addComponent(new Button("Row " + i), 0, i);
    }

    // Add some components of various shapes.
    grid.addComponent(new Button("3x1 button"), 1, 1, 3, 1);
    grid.addComponent(new Label("1x2 cell"), 1, 2, 1, 3);
    InlineDateField date = new InlineDateField("A 2x2 date field");
    date.setResolution(DateField.RESOLUTION_DAY);
    grid.addComponent(date, 2, 2, 3, 3);
    }

//public class PersonForm extends FormLayout {
// // Define the input fields for data.
// TextField firstName = new TextField("First name");
// TextField lastName = new TextField("Last name");
// TextField email = new TextField("Email");
// DateField birthday = new DateField("Birthday");
//
//     public PersonForm() {
//         addComponents(firstName, lastName, email, birthday);
//     }
// }

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
                    
                    /**
                     * 
                     */
                    private static final long serialVersionUID = 1L;

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
}
