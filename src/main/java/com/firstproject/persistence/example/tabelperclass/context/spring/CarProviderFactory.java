package com.firstproject.persistence.example.tabelperclass.context.spring;

import com.firstproject.persistence.example.tabelperclass.providers.spring.ClassCarProviderSpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
@Configuration
public class CarProviderFactory {

    @Bean(name = "classCarProviderSpring")
    @Scope("prototype")
    public ClassCarProviderSpring classCarProviderSpring(Class<? extends ClassCarProviderSpring> clazz) {
        try {
            return clazz.newInstance();
        } catch (ReflectiveOperationException e) {
            System.out.println("ooops");
        }
        return null;
    }
}
