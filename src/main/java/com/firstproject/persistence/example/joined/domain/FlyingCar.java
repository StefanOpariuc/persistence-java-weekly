package com.firstproject.persistence.example.joined.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "jn_flying_car")
public class FlyingCar extends Car {

    @Column(name = "wing")
    private String wing;

    public FlyingCar(){}
    public FlyingCar(String engine, String wing) {
        super(engine);
        this.wing = wing;
    }


    public String getWing() {
        return this.wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }
}
