package com.firstproject.persistence.example.tabelperclass.providers.spring;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import com.firstproject.persistence.example.tabelperclass.domain.NormalCar;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
public class NormalCarCarProviderSpring implements ClassCarProviderSpring {

    @Override
    public Car provideCar() {
       return new NormalCar("normal-car-engine-spring","dem-wheels");
    }
}
