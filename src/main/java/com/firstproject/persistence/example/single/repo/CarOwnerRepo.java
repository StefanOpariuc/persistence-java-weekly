package com.firstproject.persistence.example.single.repo;

import com.firstproject.persistence.example.single.domain.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stefan (Stefan.Opariuc@tss-yonder.com)
 * @since 14/06/2017
 **/
public interface CarOwnerRepo extends JpaRepository<CarOwner, Long> {
}
