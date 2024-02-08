package com.nobroker.repository;

import com.nobroker.entity.ResidentialProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentialPropertyRepository extends JpaRepository<ResidentialProperty, Long> {
    // You can add custom query methods if needed
}
