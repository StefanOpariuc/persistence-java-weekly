package com.firstproject.persistence.example.mappedsuperclass.repo;

import com.firstproject.persistence.example.mappedsuperclass.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 14/06/2017
 **/
public interface NormalCarRepo extends JpaRepository<Car,Long> {
}
