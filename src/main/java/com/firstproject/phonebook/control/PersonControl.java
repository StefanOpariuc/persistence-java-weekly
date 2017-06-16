
package com.firstproject.phonebook.control;

import com.firstproject.phonebook.POJOs.Person;
import com.firstproject.phonebook.POJOs.PhoneBook;
import com.firstproject.phonebook.repo.PersonRepo;
import com.firstproject.phonebook.repo.PhoneBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by StefanO on 22.04.2016.
 */

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PersonControl {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private PhoneBookRepo phoneBookRepo;


    public Person save(Person p) {
        PhoneBook ph = phoneBookRepo.findByCityName(p.getPhoneBook().getCityName());
        if (ph != null) {
            p.setPhoneBook(ph);
        } else {
            p.setPhoneBook(phoneBookRepo.save(p.getPhoneBook()));
        }
        return personRepo.save(p);
    }

    public Person findById(Long id) {
        return personRepo.findOne(id);
    }

    public void delete(Long id) {
        personRepo.delete(id);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public List<Person> findByFirstNameAndLastName(String firstName, String lastName){
        return this.personRepo.findByFirstNameAndLastName(firstName, lastName);
    }

}
