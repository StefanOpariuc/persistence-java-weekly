package com.firstproject.persistence.example.mappedsuperclass.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "mc_normal_car")
public class NormalCar extends Car {

    @Column(name = "wheel")
    private String wheel;

    public NormalCar() {
    }

    public NormalCar(String engine, String wheel) {
        super(engine);
        this.wheel = wheel;
    }
}
