package com.firstproject.phonebook.control;

import com.firstproject.phonebook.POJOs.Person;
import com.firstproject.phonebook.POJOs.PhoneBook;
import com.firstproject.phonebook.errors.ServerError;
import com.firstproject.phonebook.repo.PersonRepo;
import com.firstproject.phonebook.repo.PhoneBookRepo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StefanO on 25.04.2016.
 */
@Service
@Transactional
public class PhoneBookControl {

    @Autowired
    private PhoneBookRepo phoneBookRepo;

    @Autowired
    private PersonRepo personRepo;

    public PhoneBook save(PhoneBook phoneBook) {
        PhoneBook ph = phoneBookRepo.save(phoneBook);
        if (!CollectionUtils.isEmpty(phoneBook.getPersons())) {
            for (Person p : phoneBook.getPersons()) {
                if (p.getTelephoneNumber().substring(0, 3).equals(phoneBook.getPrefix())) {
                    p.setPhoneBook(ph);
                    personRepo.save(p);
                } else {
                    throw new ServerError("Prefix is not right");
                }
            }
        }
        return ph;
    }

    public PhoneBook findById(Long id) {
        return phoneBookRepo.findOne(id);
    }

    public void delete(Long id) {
        PhoneBook ph = this.phoneBookRepo.findOne(id);
        if (!CollectionUtils.isEmpty(ph.getPersons())) {
            for (Person p : ph.getPersons()) {
                this.personRepo.delete(p.getId());
            }
        }
        this.phoneBookRepo.delete(ph.getId());
    }

    public List<PhoneBook> findAll() {
        return phoneBookRepo.findAll();
    }

    public PhoneBook findByCityName(String name) {
        return phoneBookRepo.findByCityName(name);
    }

    public PhoneBook addPersons(List<Person> personList, long id) {
        PhoneBook ph = phoneBookRepo.findOne(id);
        for (Person person : personList) {
            person.setPhoneBook(ph);
            personRepo.save(person);
        }
        ph.setPersons(personList);
        return phoneBookRepo.save(ph);
    }
}
