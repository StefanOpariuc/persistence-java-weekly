package com.firstproject.persistence.example.tabelperclass.context.normal;

import com.firstproject.persistence.example.tabelperclass.providers.normal.CarProvider;
import javassist.NotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 01/07/2017
 **/
public final class CarRegistry {

    private static Map<String, CarProvider> instanceRegistry =
            Collections.synchronizedMap(new HashMap<String, CarProvider>());

    public static void registerCarProvider(@NotNull String name, @NotNull CarProvider instance) {
        CarRegistry.instanceRegistry.put(name, instance);
    }
    public static CarProvider getCarProvider(@NotNull String name) throws NotFoundException {
        if (CarRegistry.instanceRegistry.containsKey(name)) {
            return CarRegistry.instanceRegistry.get(name);
        }

        throw new NotFoundException("No provider registered with name '" + name + "'");
    }

    private CarRegistry() {
    }
}
