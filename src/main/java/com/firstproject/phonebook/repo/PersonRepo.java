package com.firstproject.phonebook.repo;

import com.firstproject.phonebook.POJOs.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by StefanO on 10.02.2016.
 */
public interface PersonRepo extends JpaRepository<Person, Long> {

    public List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
