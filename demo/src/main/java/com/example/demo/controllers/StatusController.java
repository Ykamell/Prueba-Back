package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.StatusModel;
import com.example.demo.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados")
public class StatusController {
    @Autowired
    StatusRepository estadoRepository;

    @GetMapping("/listar")
    public List<StatusModel> listarEstados() {
        return estadoRepository.findAll();
    }
}
