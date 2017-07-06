package com.firstproject.persistence.example.tabelperclass.api;

import com.firstproject.persistence.example.tabelperclass.context.normal.CarRegistry;
import com.firstproject.persistence.example.tabelperclass.context.spring.CarProviderFactory;
import com.firstproject.persistence.example.tabelperclass.context.spring.CarRegistrySpring;
import com.firstproject.persistence.example.tabelperclass.providers.normal.CarProvider;
import com.firstproject.persistence.example.tabelperclass.providers.spring.CarProviderSpring;
import com.firstproject.persistence.example.tabelperclass.providers.spring.ClassCarProviderSpring;
import com.firstproject.persistence.example.tabelperclass.repo.CarRepo;
import com.firstproject.persistence.example.tabelperclass.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 01/07/2017
 **/
@Path("/car")
public class CarApi {

    @Autowired
    private ApplicationContext applicationContext;

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Car requestCar(@QueryParam("type") String carType) throws javassist.NotFoundException {
        CarProvider provider = CarRegistry.getCarProvider(carType);
        return provider.provideCar();
    }

    @GET
    @Path("/spring")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Car requestCarSpring(@QueryParam("type") String carType) throws javassist.NotFoundException {
        ClassCarProviderSpring carProviderSpring = (ClassCarProviderSpring) applicationContext.getBean("classCarProviderSpring",CarRegistrySpring.getCarProvider(carType));
        return carProviderSpring.provideCar();
    }

}
