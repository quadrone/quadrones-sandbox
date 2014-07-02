package com.csg.example.view.webcontent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csg.example.view.MainExampleWindow;
import com.csg.example.view.data.Informable;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;

/**
 * Genericized Form where 'AForm' is a Form object and 'Pojo' is a container object that binds to the fields
 * in the 'AForm' form.
 */
@SuppressWarnings("serial")
public class GenericForm<AForm, Pojo> extends VerticalLayout
{
    private static Log log = LogFactory.getLog(GenericForm.class);
    
    /** A cheap and easy way to get a hold of forms that are created using this GenericForm */
    private Form specificInstance;
    
    /** A cheap and easy way to get a hold of POJOs that underlie this GenericForm */
    private Informable ourPojo;

    /**
     * Constructor
     * 
     * @param formClazz - the class instance of the form being used
     * @param pojoClazz - the class instance of the pojo being used
     */
    public GenericForm(Class<AForm> formClazz, Class<Pojo> pojoClazz)
    {
        try
        {
            Pojo pojo = pojoClazz.newInstance();
            ourPojo = (Informable)pojo;
            BeanItem<Pojo> anItem = new BeanItem<Pojo>(pojo);

            @SuppressWarnings("unchecked")
            final GenericFormLayout<Pojo> aForm = (GenericFormLayout<Pojo>) formClazz.newInstance();
            aForm.instantiate(anItem);// polymorphically instantiate our form
            specificInstance = aForm.getSpecificInstance();

            // Add form to layout
            setSizeFull();
            setWidth(null);
            addComponent((Component) aForm);
            setComponentAlignment((Component)aForm, Alignment.TOP_CENTER);

        } catch (InstantiationException ie)
        {
            log.error(ie.toString());
        } catch (IllegalAccessException iae)
        {
            log.error(iae.toString());
        } catch (ClassCastException cce)
        {
            log.error(cce.toString());
        }
    }

    /**
     * @return the specificInstance
     */
    public Form getSpecificInstance()
    {
        return specificInstance;
    }
    
    /**Convenience method to access mainWindow
     * 
     * @return the main window
     */
    public MainExampleWindow getMainWindow()
    {
        return (MainExampleWindow)specificInstance.getApplication().getMainWindow();
    }

    /**
     * @return the bean associated with the 'specificInstance'
     */
    public Informable getOurPojo()
    {
        return ourPojo;
    }
}
