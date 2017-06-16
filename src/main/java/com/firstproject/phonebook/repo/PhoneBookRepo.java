package com.firstproject.phonebook.repo;

import com.firstproject.phonebook.POJOs.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by StefanO on 25.04.2016.
 */
public interface PhoneBookRepo extends JpaRepository<PhoneBook, Long> {

    public PhoneBook findByCityName(String name);

}
