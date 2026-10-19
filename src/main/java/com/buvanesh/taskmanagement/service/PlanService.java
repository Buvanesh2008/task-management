package com.buvanesh.taskmanagement.service;

import com.buvanesh.taskmanagement.entity.Plan;
import com.buvanesh.taskmanagement.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }
}
