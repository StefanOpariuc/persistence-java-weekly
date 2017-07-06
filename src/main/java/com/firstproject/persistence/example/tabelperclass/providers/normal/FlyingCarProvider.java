package com.firstproject.persistence.example.tabelperclass.providers.normal;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import com.firstproject.persistence.example.tabelperclass.domain.FlyingCar;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 01/07/2017
 **/
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(rollbackFor = Exception.class)public class FlyingCarProvider implements CarProvider {

    private final String carType = "FlyingCar";

    @Override
    public String getCarType(){
        return this.carType;
    }

    @Override
    public Car provideCar(){
        return new FlyingCar("flyingCarEngine","demWings");
    }
}
