package com.firstproject.phonebook.POJOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.firstproject.phonebook.validator.TelephoneNumber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Created by StefanO on 05.02.2016.
 */
@Entity(name = "person")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"last_name", "telephone_number", "phone_book_id"}, name = "unique_constraint_person")})
public class Person {

    @Column(name = "pr_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "age")
    private long age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone_number")
    @TelephoneNumber
    @NotNull
    private String telephoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_book_id", referencedColumnName = "ph_id")
    @JsonBackReference
    private PhoneBook phoneBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
