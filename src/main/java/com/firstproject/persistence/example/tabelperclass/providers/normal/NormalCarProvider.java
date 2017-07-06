package com.firstproject.persistence.example.tabelperclass.providers.normal;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import com.firstproject.persistence.example.tabelperclass.domain.NormalCar;
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
@Transactional(rollbackFor = Exception.class)
public class NormalCarProvider implements CarProvider {

    private final String carType = "NormalCar";

    @Override
    public String getCarType(){
        return this.carType;
    }

    @Override
    public Car provideCar(){
        return new NormalCar("normalCarEngine","demWheels");
    }

}
