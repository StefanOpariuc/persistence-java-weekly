package com.firstproject.persistence.example.tabelperclass.providers.spring;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import com.firstproject.persistence.example.tabelperclass.domain.FlyingCar;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
public class FlyingCarCarProviderSpring implements ClassCarProviderSpring {


    @Override
    public Car provideCar() {
       return new FlyingCar("flying-car-engine-spring","dem-wings");
    }
}
