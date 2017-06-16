package com.firstproject.persistence.example.tabelperclass.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "tpc_car")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "engine")
    protected String engine;

    @ManyToMany
    @JoinTable(name = "tpc_car_owner_to_car", joinColumns = { @JoinColumn(name = "car_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "owner_id",
            referencedColumnName ="id") })
    private List<CarOwner> owners;

    public Car() {
    }

    public Car(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public List<CarOwner> getOwners() {
        return this.owners;
    }

    public void setOwners(List<CarOwner> owners) {
        this.owners = owners;
    }
}
