package com.firstproject.persistence.example.tabelperclass.context.spring;

import com.firstproject.persistence.example.tabelperclass.providers.spring.CarProviderSpring;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Set;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
public class CarContextSpring implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Reflections reflections = new Reflections("com.firstproject.persistence.example.tabelperclass");
        Set<Class<?>> cars = reflections.getTypesAnnotatedWith(CarProviderSpring.class);
        for (Class<?> car : cars) {
            CarProviderSpring annotation = (CarProviderSpring) car.getAnnotation(CarProviderSpring.class);
            CarRegistrySpring.registerCarProvider(annotation.name(), annotation.carProviderSpring());
        }
    }
}
