package com.firstproject.persistence.example.mappedsuperclass.repo;

import com.firstproject.persistence.example.mappedsuperclass.domain.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 14/06/2017
 **/
public interface CarOwnerRepo extends JpaRepository<CarOwner, Long> {
}
