package com.nobroker.service;

import com.nobroker.entity.ResidentialProperty;
import com.nobroker.repository.ResidentialPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ResidentialPropertyService {
    private final ResidentialPropertyRepository propertyRepository;

    @Autowired
    public ResidentialPropertyService(ResidentialPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public ResidentialProperty saveProperty(ResidentialProperty property) {
        property.setStatus("pending");
        return propertyRepository.save(property);
    }

    public ResidentialProperty updatePropertyStatus(Long id, String newStatus) {
        ResidentialProperty property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));
        property.setStatus(newStatus);
        return propertyRepository.save(property);
    }

    public ResidentialProperty updateUserId(Long id, Long userId) {
        ResidentialProperty property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));
        property.setUserId(userId);
        return propertyRepository.save(property);
    }
}
