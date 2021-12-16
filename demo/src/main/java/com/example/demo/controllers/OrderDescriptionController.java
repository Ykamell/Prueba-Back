package com.example.demo.controllers;

import com.example.demo.models.OrderDescriptionModel;
import com.example.demo.repositories.OrderDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ordenes/desc")
public class OrderDescriptionController {
    @Autowired
    OrderDescriptionRepository descripcionOrdenRepository;

    @GetMapping("/listar")
    public List<OrderDescriptionModel> listarOrdenes() {
        return descripcionOrdenRepository.findAll();
    }

    @PostMapping("/crear")
    public OrderDescriptionModel crearOrden(OrderDescriptionModel desc_orden) {
        return descripcionOrdenRepository.save(desc_orden);

    }
}
