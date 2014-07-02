package com.csg.example.view.data;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TwinColSelect;

/**Factory for building fields for the General Info bean.*/
@SuppressWarnings("serial")
public class GeneralInfoFieldFactory extends DefaultFieldFactory
{
    final private TwinColSelect emailList = new TwinColSelect("Client Requestor Email");

    /**Constructor
     * Define how fields are displayed*/
    public GeneralInfoFieldFactory() 
    {        
        emailList.setWidth("48em");
        emailList.setRows(4);
        emailList.setLeftColumnCaption("(Available addresses)");
        emailList.setRightColumnCaption("(Selected addresses)");
        emailList.setNullSelectionAllowed(true);
        emailList.setNewItemsAllowed(true);
    }

    
    @Override
    public Field createField(Item item, Object propertyId, Component uiContext)
    {
        Field field;
        if(GeneralInfo.fieldNames.email.toString().equals(propertyId))
        {
            return emailList;
        } else
        {// Use the super class to create a suitable field base on the property type.
            field = super.createField(item, propertyId, uiContext);
        }

        return field;
    }
}
