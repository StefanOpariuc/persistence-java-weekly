package com.firstproject.parallelism;

import com.firstproject.persistence.example.single.domain.Car;
import com.firstproject.persistence.example.single.domain.FlyingCar;
import com.firstproject.persistence.example.single.domain.NormalCar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 26/06/2017
 **/
public class ParallelProccesor {

    public static void main(String[] args) {
        Map<String, Car> mapOfCars  = new HashMap<>();
        List<Car> cars = createCars();
        /*long startTime = System.currentTimeMillis();
        cars.stream().collect(Collectors.toMap(Car::getEngine, car->car));

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time with parallel stream= "+elapsedTime);*/

       long startTimeOfNormalComp = System.currentTimeMillis();

        for(Car car : cars){
            mapOfCars.put(car.getEngine(),car);
        }
        long stopTimeOfNormalComp = System.currentTimeMillis();
        long elapsedTimeOfNormalComp = stopTimeOfNormalComp - startTimeOfNormalComp;
        System.out.println("Time with normal computation= "+elapsedTimeOfNormalComp);
    }

    private static List<Car> createCars(){
        List<Car> cars = new ArrayList<>();
        for(long i = 0; i<=1_000_000; i++){
            Car car1 = new FlyingCar("fly-engine"+i,"wing"+i);
            Car car3 = new FlyingCar("fly-special-engine"+i,"wing"+i);
            Car car2 = new NormalCar("normal-engine"+i,"wheel"+i);
            Car car4 = new NormalCar("normal-special-engine"+i,"wheel"+i);
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            cars.add(car4);
        }
        return cars;
    }
}
