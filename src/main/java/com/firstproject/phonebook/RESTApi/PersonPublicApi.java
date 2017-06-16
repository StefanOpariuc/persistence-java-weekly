package com.firstproject.phonebook.RESTApi;

import com.firstproject.phonebook.POJOs.Person;
import com.firstproject.phonebook.control.PersonControl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 19.01.2017
 **/
@Path("/person")
public class PersonPublicApi {

/*
    @Autowired
    private PersonControl personControl;
*/

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Person> getPerson(@QueryParam("firstName") String firstName,
                                  @QueryParam("lastName") String lastName) {
     //   return personControl.findByFirstNameAndLastName(firstName, lastName);
        return null;
    }
}
