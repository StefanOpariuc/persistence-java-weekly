package com.firstproject.phonebook.POJOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

/**
 * Created by StefanO on 25.04.2016.
 */
@Entity(name = "phone_book")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"prefix", "city_name"}, name = "unique_constraint_phone_book")})
public class PhoneBook {

    @Column(name = "ph_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "prefix")
    private String prefix;

    @OneToMany(mappedBy = "phoneBook", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Person> persons;


    @Column(name = "city_name")
    private String cityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
