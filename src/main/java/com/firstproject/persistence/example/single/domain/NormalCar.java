package com.firstproject.persistence.example.single.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "sg_normal_car")
@DiscriminatorValue("NormalCar")
public class NormalCar extends Car {

    @Column(name = "wheel")
    private String wheel;

    public NormalCar(String engine,String wheel) {
        super(engine);
        this.wheel = wheel;
    }

    public NormalCar() {
    }
}
