package com.buvanesh.taskmanagement.controller;

import com.buvanesh.taskmanagement.entity.Plan;
import com.buvanesh.taskmanagement.service.PlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService){
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> getAllPlans(){
        return planService.getAllPlans();
    }
}
