package com.nobroker.controller;

import com.nobroker.entity.ResidentialProperty;
import com.nobroker.request.PropertyStatusUpdateRequest;
import com.nobroker.request.PropertyUserUpdateRequest;
import com.nobroker.service.ResidentialPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
public class ResidentialPropertyController {

    private final ResidentialPropertyService propertyService;

    @Autowired
    public ResidentialPropertyController(ResidentialPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    //http://localhost:8080/properties
    @PostMapping
    public ResponseEntity<ResidentialProperty> addProperty(@RequestBody ResidentialProperty property) {
        ResidentialProperty savedProperty = propertyService.saveProperty(property);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    //http://localhost:8080/properties/{id}/status
    @PatchMapping("/{id}/status")
    public ResponseEntity<ResidentialProperty> updatePropertyStatus(
            @PathVariable Long id,
            @RequestBody PropertyStatusUpdateRequest request) {
        ResidentialProperty updatedProperty = propertyService.updatePropertyStatus(id, request.getStatus());
        return ResponseEntity.ok(updatedProperty);
    }

    //http://localhost:8080/properties/{id}/user
    @PatchMapping("/{id}/user")
    public ResponseEntity<ResidentialProperty> updatePropertyUserId(
            @PathVariable Long id,
            @RequestBody PropertyUserUpdateRequest request) {
        ResidentialProperty updatedProperty = propertyService.updateUserId(id, request.getUserId());
        return ResponseEntity.ok(updatedProperty);
    }
}
