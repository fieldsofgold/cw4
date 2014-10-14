/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 *
 * @author nl
 */
public class ClientListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        if(srae.getName().equals("lastAddedClient")){
            Integer counter = (Integer) srae.getServletContext().getAttribute("savedClientsCounter");
            if (counter==null){
                counter = new Integer(1);
            } else {
                counter++;
            }
            srae.getServletContext().setAttribute("savedClientsCounter",counter);
        }
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
    }

}
