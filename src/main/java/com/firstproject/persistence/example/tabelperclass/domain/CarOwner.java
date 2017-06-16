package com.firstproject.persistence.example.tabelperclass.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "tpc_car_owner")
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @ManyToMany(mappedBy = "owners",fetch = FetchType.EAGER)
    private List<Car> carList;

    public CarOwner() {
    }

    public CarOwner(List<Car> carList) {
        this.carList = carList;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
