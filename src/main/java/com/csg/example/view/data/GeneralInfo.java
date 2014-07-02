package com.csg.example.view.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Container object for general information.*/
public class GeneralInfo implements Informable
{
    public static enum fieldNames {email};
    
    private Set<String> email = new HashSet<String>();
    
    @Override
    public void resetFieldsToDefault()
    {
        email = new HashSet<String>();
    }
    
   
    /**
     * @return the email
     */
    public Set<String> getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Set<String> email)
    {
        this.email = email;
    }

    @Override
    public List<String> fetchFieldsForDB()
    {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }
}
