package com.csg.example.view.panels;

import java.util.HashMap;

import com.csg.example.view.data.GeneralInfo;
import com.csg.example.view.webcontent.GeneralInfoForm;
import com.csg.example.view.webcontent.GenericForm;
import com.vaadin.ui.VerticalLayout;

/**Panel for displaying components.*/
@SuppressWarnings("serial")
public class DisplayPanel extends VerticalLayout
{
    /**Constructor*/
    public DisplayPanel()
    {
        setSizeUndefined();
        addComponent(new GenericForm<GeneralInfoForm,GeneralInfo>(GeneralInfoForm.class, GeneralInfo.class));
        
        //throw in some values
        HashMap<String,String> emails = new HashMap<String,String>();
        emails.put("don@abc.com", "blah");
        emails.put("bill@abc.com", "blah");
        emails.put("bob@abc.com", "blah");
        
        ((GeneralInfoForm)((GenericForm<?, ?>)getComponent(0)).getSpecificInstance()).
        addEmailAddresses(emails);
    }
}
