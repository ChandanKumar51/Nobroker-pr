// SellerPlanService.java
package com.nobroker.service;

import com.nobroker.entity.SellerPlan;
import com.nobroker.repository.SellerPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerPlanService {

    private final SellerPlanRepository sellerPlanRepository;

    @Autowired
    public SellerPlanService(SellerPlanRepository sellerPlanRepository) {
        this.sellerPlanRepository = sellerPlanRepository;
    }

    public SellerPlan subscribeSellerPlan(SellerPlan sellerPlan) {
        // Additional logic for subscription process, if any
        return sellerPlanRepository.save(sellerPlan);
    }

    public SellerPlan getSellerPlanById(Long id) {
        return sellerPlanRepository.findById(id).orElse(null);
    }

    // Additional methods for update, delete, etc.
}
