package com.firstproject.persistence.example.tabelperclass.context.normal;

import com.firstproject.persistence.example.tabelperclass.providers.normal.CarProvider;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Set;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 01/07/2017
 **/
public class CarContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Reflections reflections = new Reflections("com.firstproject.persistence.example.tabelperclass");
        Set<Class<? extends CarProvider>> carProviders = reflections.getSubTypesOf(CarProvider.class);
        for (Class<? extends CarProvider> handler : carProviders) {
            CarProvider beanInstance = applicationContext.getBean(handler);
            CarRegistry.registerCarProvider(beanInstance.getCarType(), beanInstance);
        }
    }
}
