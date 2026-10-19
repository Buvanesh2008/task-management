package com.buvanesh.taskmanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(name = "plan_name", nullable = false, unique = true)
    private String planName;

    @Column(name = "max_dashboards", nullable = false)
    private Integer maxDashboards;

    @Column(name = "max_tasks_per_dashboard", nullable = false)
    private Integer maxTasksPerDashboard;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean active = true;


    public Long getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public Integer getMaxDashboards() {
        return maxDashboards;
    }

    public Integer getMaxTasksPerDashboard() {
        return maxTasksPerDashboard;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getActive() {
        return active;
    }

}
