package com.csg.example.view.webcontent;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;

/**Interface for instantiating forms in a generic fashion. Pojo represents a container class that 
 * will bind to the form being created.*/
public interface GenericFormLayout<Pojo>
{
    /**Responsible for instantiating the Form by defining which field to display, and by binding 
     * form fields to the BeanItem.
     * @param bean - an instantiated bean that is bound to a Pojo object.
     */
    void instantiate(BeanItem<Pojo> bean);
    
    /**Retrieve the specific instance of the form created from this interface*/
    Form getSpecificInstance();

}
