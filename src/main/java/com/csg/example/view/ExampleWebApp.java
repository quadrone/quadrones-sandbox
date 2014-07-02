package com.csg.example.view;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.*;

/**Entry page*/
@SuppressWarnings("serial")
public class ExampleWebApp extends Application
{    
    @Override
    public void init()
    {
        setTheme("exampletheme");
        setLogoutURL(getURL().toString());
        setMainWindow(new MainExampleWindow());
    }
    
    /** Overriding getWindow(String) is required to get multiple browser windows/tabs to work*/
    @Override
    public Window getWindow(String name) {

        // If the window is identified by name, we are good to go
        Window w = super.getWindow(name);

        // If not, we must create a new window for this new browser window/tab
        if (w == null) {
            w = new MainExampleWindow();

            // Use the random name given by the framework to identify this
            // window in future
            w.setName(name);
            addWindow(w);

            // Move to the url to remember the name in the future
            w.open(new ExternalResource(w.getURL()));
        }

        return w;
    }
}
