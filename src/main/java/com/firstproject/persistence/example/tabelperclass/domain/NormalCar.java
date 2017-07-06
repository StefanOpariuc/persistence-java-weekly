package com.firstproject.persistence.example.tabelperclass.domain;

import com.firstproject.persistence.example.tabelperclass.providers.spring.CarProviderSpring;
import com.firstproject.persistence.example.tabelperclass.providers.spring.FlyingCarCarProviderSpring;
import com.firstproject.persistence.example.tabelperclass.providers.spring.NormalCarCarProviderSpring;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 12/06/2017
 **/
@Entity(name = "tpc_normal_car")
@CarProviderSpring(name="NormalCar",carProviderSpring = NormalCarCarProviderSpring.class)
public class NormalCar extends Car {

    @Column(name = "wheel")
    private String wheel;

    public NormalCar(){}

    public NormalCar(String engine, String wheel) {
        super(engine);
        this.wheel = wheel;
    }

    public String getWheel() {
        return this.wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }
}
