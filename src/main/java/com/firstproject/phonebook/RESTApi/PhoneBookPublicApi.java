package com.firstproject.phonebook.RESTApi;

import com.firstproject.phonebook.POJOs.Person;
import com.firstproject.phonebook.POJOs.PhoneBook;
import com.firstproject.phonebook.control.PhoneBookControl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 19.01.2017
 **/
@Path("/phonebook")
public class PhoneBookPublicApi {
/*
    @Autowired
    private PhoneBookControl phoneBookControl;*/

   /* @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<PhoneBook> getPhonebook() {
        return phoneBookControl.findAll();
    }

    @POST
    @Path("/")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public PhoneBook savePhoneBook(PhoneBook ph) {
        return this.phoneBookControl.save(ph);
    }

    @POST
    @Path("/persons")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public PhoneBook addPersons(List<Person> persons, @QueryParam("id") long id) {
        return this.phoneBookControl.addPersons(persons, id);
    }
*/
    @DELETE
    @Path("/")
    public void deletePhoneBook(@QueryParam("id") long id) {
        //this.phoneBookControl.delete(id);
    }

}
