package com.csg.example.view.webcontent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csg.example.view.panels.DisplayPanel;
import com.vaadin.ui.TabSheet;

/**Creates tabbed web page structure for macro tool.*/
@SuppressWarnings("serial")
public class ExampleTabSheet extends TabSheet
{
    private static Log log = LogFactory.getLog(ExampleTabSheet.class);
    
    //enumeration of tabs for easy access. enumeration must be in same order as tabs are added
    public static enum TabEnum
    {
        Example
    };
    
    /**Constructor
     * 
     * @param sessionInfo - instantiated sessionInfo object
     */
    public ExampleTabSheet()
    {
        setSizeFull();//all pages use up available screen 
        
        //set the style name
        String style = "mainTabSheet";
        
        //add tabs
        addTab(new DisplayPanel(), "Example").setStyleName(style);
        
        log.trace("Created Tabsheet");
    }    
    
    /**Convenience method to switch tabs from anywhere in the web application
     * 
     * @param tab - the enumerated tab we wish to switch to
     */
    public void switchTab(TabEnum tab)
    {
        switch(tab)
        {
        case Example:
            setSelectedTab(TabEnum.Example.ordinal());
            break;
        default:
            break;
        }
    }

}
