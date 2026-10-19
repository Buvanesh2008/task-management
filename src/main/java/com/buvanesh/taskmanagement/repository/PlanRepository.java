package com.buvanesh.taskmanagement.repository;

import com.buvanesh.taskmanagement.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
