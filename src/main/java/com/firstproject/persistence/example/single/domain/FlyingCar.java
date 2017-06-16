package com.firstproject.persistence.example.single.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "sg_flying_car")
@DiscriminatorValue("FlyingCar")
public class FlyingCar extends Car {

    @Column(name = "wing")
    private String wing;

    public FlyingCar(){}
    public FlyingCar(String engine, String wing) {
        super(engine);
        this.wing = wing;
    }

}
