package com.firstproject.persistence.example.tabelperclass.providers.normal;

import com.firstproject.persistence.example.tabelperclass.domain.Car;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 01/07/2017
 **/
public interface CarProvider {

    String getCarType();

    Car provideCar();
}
