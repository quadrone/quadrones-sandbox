package com.csg.example.view.webcontent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csg.example.view.data.GeneralInfo;
import com.csg.example.view.data.GeneralInfoFieldFactory;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TwinColSelect;

/**Form definition for GeneralInfo*/
@SuppressWarnings("serial")
public class GeneralInfoForm extends Form implements GenericFormLayout<GeneralInfo>
{

    private static Log log = LogFactory.getLog(GeneralInfoForm.class);
    private GridLayout ourLayout;

    @Override
    public void instantiate(BeanItem<GeneralInfo> item)
    {
        setCaption("General Information");

        ourLayout = new GridLayout(10, 5);

        ourLayout.setSpacing(true);
        ourLayout.setMargin(true);

        setLayout(ourLayout);

        // no invalid values in datamodel
        setInvalidCommitted(false);

        // FieldFactory for customizing the fields and adding validators
        setFormFieldFactory(new GeneralInfoFieldFactory());
        setItemDataSource(item); 

        //set all the fields to be visible
        ArrayList<String> fields = new ArrayList<String>();
        for(GeneralInfo.fieldNames field : GeneralInfo.fieldNames.values())
        {
                fields.add(field.toString());
        }
        setVisibleItemProperties(fields);
    }
    
    /**Set the email list
     * 
     * @param map - map where keys are email addresses
     */
    public void addEmailAddresses(Map<String,String> map)
    {
        StringBuilder sb = new StringBuilder("Attempting to add external email addresses: ");
        Iterator<Component> iter = ourLayout.getComponentIterator();
        Set<String> defaulted = new HashSet<String>();//collection of defaulted email addresses
        while(iter.hasNext())
        {
            Component comp = iter.next();
            if(comp instanceof TwinColSelect)//this assumes only one TwinColSelect is in the Component list
            {
                //clear the selector then populate it
                ((TwinColSelect)comp).removeAllItems();
                for(String address : map.keySet())
                {
                    ((TwinColSelect)comp).addItem(address);
                    sb.append(address);
                }
                ((TwinColSelect)comp).setValue(defaulted);
            }
        }
        log.trace(sb.toString());
    }

    /*
     * Override to get control over where fields are placed.
     */
    @Override
    protected void attachField(Object propertyId, Field field)
    {
        if (propertyId.equals(GeneralInfo.fieldNames.email.toString()))
        {
            ourLayout.addComponent(field, 0, 0, 3, 2);
        }
    }

    @Override
    public Form getSpecificInstance()
    {
        return this;
    }
}
