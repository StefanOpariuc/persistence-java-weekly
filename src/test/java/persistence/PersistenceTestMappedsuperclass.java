package persistence;

import com.firstproject.persistence.example.mappedsuperclass.domain.Car;
import com.firstproject.persistence.example.mappedsuperclass.domain.CarOwner;
import com.firstproject.persistence.example.mappedsuperclass.domain.FlyingCar;
import com.firstproject.persistence.example.mappedsuperclass.domain.NormalCar;
import com.firstproject.persistence.example.mappedsuperclass.repo.CarOwnerRepo;
import com.firstproject.persistence.example.mappedsuperclass.repo.FlyingCarRepo;
import com.firstproject.persistence.example.mappedsuperclass.repo.NormalCarRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 14/06/2017
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class PersistenceTestMappedsuperclass {
    @Autowired
    private CarOwnerRepo carOwnerRepo;

    @Autowired
    private FlyingCarRepo flyingCarRepo;

    @Autowired
    private NormalCarRepo normalCarRepo;

    @Test
    public void testTheInsertion() {
        Car flyingCar1 = new FlyingCar("Flying_car_engine", "dem_wings");
        Car flyingCar2 = new FlyingCar("Flying_car_engine2", "dem_wings2");

        Car normalCar1 = new NormalCar("Normal_car_engine", "dem_wheels");
        Car normalCar2 = new NormalCar("Normal_car_engine2", "dem_wheels2");

        flyingCarRepo.save(Arrays.asList(flyingCar1, flyingCar2));
        normalCarRepo.save(Arrays.asList(normalCar1, normalCar2));

     //   CarOwner carOwner = new CarOwner(Arrays.asList(flyingCar1, flyingCar2, normalCar1, normalCar2));


       /* carOwnerRepo.save(carOwner);
        flyingCar1.setOwners(Arrays.asList(carOwner));
        flyingCar2.setOwners(Arrays.asList(carOwner));
        normalCar1.setOwners(Arrays.asList(carOwner));
        flyingCar2.setOwners(Arrays.asList(carOwner));*/
        flyingCarRepo.save(Arrays.asList(flyingCar1, flyingCar2));
        normalCarRepo.save(Arrays.asList(normalCar1, normalCar2));


    }

    @Test
    public void testTheSelect() {
        List<CarOwner> carOwners = carOwnerRepo.findAll();
      //  carOwners.get(0).getCarList();
    }
}
