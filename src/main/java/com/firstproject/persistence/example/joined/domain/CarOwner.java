package com.firstproject.persistence.example.joined.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "jn_car_owner")
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private List<Car> carList;

    public CarOwner() {
    }

    public CarOwner(List<Car> carList) {
        this.carList = carList;
    }

}
