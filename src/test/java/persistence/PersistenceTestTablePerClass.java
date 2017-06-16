package persistence;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import com.firstproject.persistence.example.tabelperclass.domain.CarOwner;
import com.firstproject.persistence.example.tabelperclass.domain.FlyingCar;
import com.firstproject.persistence.example.tabelperclass.domain.NormalCar;
import com.firstproject.persistence.example.tabelperclass.repo.CarOwnerRepo;
import com.firstproject.persistence.example.tabelperclass.repo.CarRepo;
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
@ContextConfiguration("classpath:spring-config-tabelperclass.xml")
public class PersistenceTestTablePerClass {

    @Autowired
    private CarOwnerRepo carOwnerRepo;

    @Autowired
    private CarRepo carRepo;

    @Test
    public void testTheInsertion() {
        Car flyingCar1 = new FlyingCar("Flying_car_engine", "dem_wings");
        Car flyingCar2 = new FlyingCar("Flying_car_engine2", "dem_wings2");

        Car normalCar1 = new NormalCar("Normal_car_engine", "dem_wheels");
        Car normalCar2 = new NormalCar("Normal_car_engine2", "dem_wheels2");

        carRepo.save(Arrays.asList(flyingCar1, flyingCar2, normalCar1, normalCar2));

        CarOwner carOwner = new CarOwner(Arrays.asList(flyingCar1, flyingCar2, normalCar1, normalCar2));


        carOwnerRepo.save(carOwner);
        flyingCar1.setOwners(Arrays.asList(carOwner));
        flyingCar2.setOwners(Arrays.asList(carOwner));
        normalCar1.setOwners(Arrays.asList(carOwner));
        flyingCar2.setOwners(Arrays.asList(carOwner));
        carRepo.save(Arrays.asList(flyingCar1, flyingCar2, normalCar1, normalCar2));

    }

    @Test
    public void testTheSelect() {
        List<CarOwner> carOwners = carOwnerRepo.findAll();
        carOwners.get(0).getCarList();
    }
}
