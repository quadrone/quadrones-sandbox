package com.csg.example.view.panels;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


/**Responsible for the display of the title*/
@SuppressWarnings("serial")
public class TitlePanel extends Panel
{
    private String panelStyle = "titlePanel";
    
    /**Constructor - setup the panel layout and components*/
    public TitlePanel()
    {
        HorizontalLayout layout = new HorizontalLayout();
        setStyleName(panelStyle);
        layout.setWidth("100%");
        
        VerticalLayout vl = new VerticalLayout();
        vl.setWidth("24em");
        vl.setHeight("100%");
        Label titleTop = new Label("Component Sandbox");
        titleTop.setStyleName(panelStyle);
        vl.addComponent(titleTop);
        vl.setComponentAlignment(titleTop, Alignment.MIDDLE_LEFT);
        layout.addComponent(vl);
        layout.setComponentAlignment(vl, Alignment.BOTTOM_CENTER);
        
        //place all the components as laid out
        setContent(layout);
    }
}
