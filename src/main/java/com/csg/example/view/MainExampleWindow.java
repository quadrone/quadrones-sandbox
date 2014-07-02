package com.csg.example.view;

import com.csg.example.view.panels.TitlePanel;
import com.csg.example.view.webcontent.ExampleTabSheet;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;

/**This class maintains window state so that multiple browsers can open the tool and have 
 * individual state. By default state is kept at the Application level, so here we move layout 
 * initialization from the Application to Window.*/
@SuppressWarnings("serial")
public class MainExampleWindow extends Window
{    
    /**Identifier used by external objects*/
    private int index;
    
    /**Tabsheet that holds the various web application forms*/
    private TabSheet tabs;
    
    public MainExampleWindow()
    {
        setCaption("Sandbox");
        setName("TwinColSelect Example");
        TitlePanel titlePanel = new TitlePanel();
        addComponent(titlePanel);
        addComponent(new ExampleTabSheet());
    }

    /**
     * @return the index
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * @return the tabsheet
     */
    public TabSheet getTabs()
    {
        return tabs;
    }
}
