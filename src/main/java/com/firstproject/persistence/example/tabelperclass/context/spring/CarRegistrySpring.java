package com.firstproject.persistence.example.tabelperclass.context.spring;

import com.firstproject.persistence.example.tabelperclass.providers.spring.ClassCarProviderSpring;
import javassist.NotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 06/07/2017
 **/
public class CarRegistrySpring  {

    private static Map<String, Class<? extends ClassCarProviderSpring>> instanceRegistry =
            Collections.synchronizedMap(new HashMap<String, Class<? extends ClassCarProviderSpring>>());

    public static void registerCarProvider(@NotNull String name, Class<? extends ClassCarProviderSpring> provider) {
        CarRegistrySpring.instanceRegistry.put(name, provider);
    }
    public static Object getCarProvider(@NotNull String name) throws NotFoundException {
        if (CarRegistrySpring.instanceRegistry.containsKey(name)) {
            return CarRegistrySpring.instanceRegistry.get(name);
        }

        throw new NotFoundException("No provider registered with name '" + name + "'");
    }

    private CarRegistrySpring() {
    }
}
