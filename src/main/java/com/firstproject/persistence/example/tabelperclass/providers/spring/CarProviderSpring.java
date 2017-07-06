package com.firstproject.persistence.example.tabelperclass.providers.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CarProviderSpring {

    Class<? extends ClassCarProviderSpring> carProviderSpring();

    String name();
}
