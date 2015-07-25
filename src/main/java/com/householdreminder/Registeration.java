package com.householdreminder;

//import java.io.Serializable;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.householdreminder.businesslogic.Message;
import com.householdreminder.businesslogic.UserLogic;
import com.householdreminder.dal.HibernateUtilities;
import com.householdreminder.model.UserDTO;

/**
 * Root resource (exposed at "Register" path)
 */
@Path("Register")
public class Registeration {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerUser(UserDTO user)
    {
    	Session session = HibernateUtilities.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	UserLogic ul = new UserLogic(session);
    	int saved = (Integer)ul.registerUser(user);
    	session.flush();
    	tx.commit();
    	session.close();
    	if( saved > 0){
    		return Message.REGISTERTION_SUCCESSFULL;
    		
    	}
    	if(saved == -1)
    	{
    		return Message.DUPLICATE_USER;
    	}
    	
    	return Message.REGISTRATION_ERROR;
    	
    }
}
