package com.csg.example.view.data;

import java.util.List;

/**Interface to allow access to Bean objects (POJOs) holding form data.*/
public interface Informable
{
    /**Getter for field names that are to be stored in the DB as parameters.
     * 
     * @return a List of field names that will be stored in the DB
     */
    public List<String> fetchFieldsForDB();
    
    /**Assure that the bean associated with a form is reset to it's default state.
     */
    public void resetFieldsToDefault();
}
