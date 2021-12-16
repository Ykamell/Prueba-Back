package com.example.demo.repositories;

import com.example.demo.models.OrderDescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDescriptionRepository extends JpaRepository<OrderDescriptionModel, Long> {
}