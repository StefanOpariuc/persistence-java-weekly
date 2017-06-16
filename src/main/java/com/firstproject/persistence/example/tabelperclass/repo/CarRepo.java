package com.firstproject.persistence.example.tabelperclass.repo;

import com.firstproject.persistence.example.tabelperclass.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 14/06/2017
 **/
public interface CarRepo extends JpaRepository<Car,Long> {
}
