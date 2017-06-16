package persistence;

import com.firstproject.persistence.example.single.domain.Car;
import com.firstproject.persistence.example.single.domain.CarOwner;
import com.firstproject.persistence.example.single.domain.FlyingCar;
import com.firstproject.persistence.example.single.domain.NormalCar;
import com.firstproject.persistence.example.single.repo.CarOwnerRepo;
import com.firstproject.persistence.example.single.repo.CarRepo;
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
@ContextConfiguration("classpath:spring-config-single.xml")
public class PersistenceTestSingle {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CarOwnerRepo carOwnerRepo;

    @Test
    public void testTheInsertion() {
        Car flyingCar1 = new FlyingCar("Flying_car_engine", "dem_wings");
        Car flyingCar2 = new FlyingCar("Flying_car_engine2", "dem_wings2");

        Car normalCar1 = new NormalCar("Normal_car_engine", "dem_wheels");
        Car normalCar2 = new NormalCar("Normal_car_engine2", "dem_wheels2");

        carRepo.save(Arrays.asList(flyingCar1, flyingCar2,normalCar1,normalCar2));

        CarOwner carOwner = new CarOwner(Arrays.asList(flyingCar1, flyingCar2, normalCar1, normalCar2));

        carOwnerRepo.save(carOwner);

    }

    @Test
    public void testTheSelect(){
        List<CarOwner> carOwners = carOwnerRepo.findAll();
        assertNotNull(carOwners);
    }
}
