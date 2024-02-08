// SellerPlanController.java
package com.nobroker.controller;

import com.nobroker.entity.SellerPlan;
import com.nobroker.service.SellerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller-plans")
public class SellerPlanController {

    private final SellerPlanService sellerPlanService;

    @Autowired
    public SellerPlanController(SellerPlanService sellerPlanService) {
        this.sellerPlanService = sellerPlanService;
    }

    // http://localhost:8080/api/seller-plans/subscribe
    @PostMapping("/subscribe")
    public SellerPlan subscribeSellerPlan(@RequestBody SellerPlan sellerPlan) {
        return sellerPlanService.subscribeSellerPlan(sellerPlan);
    }

    // http://localhost:8080/api/seller-plans/{id}
    @GetMapping("/{id}")
    public SellerPlan getSellerPlanById(@PathVariable Long id) {
        return sellerPlanService.getSellerPlanById(id);
    }

    // Additional endpoints for update, delete, etc.
}
