package com.example.demo.controllers;

import com.example.demo.models.OrderModel;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrderController {
    @Autowired
    OrderRepository ordenRepository;

    @GetMapping("/listar")
    public List<OrderModel> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @PostMapping("/crear")
    public OrderModel crearOrden(OrderModel orden) {
        return ordenRepository.save(orden);

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTutorial(@PathVariable("id") Long id) {
        ordenRepository.deleteById(id);
        return "Orden Anulada";
    }
}
