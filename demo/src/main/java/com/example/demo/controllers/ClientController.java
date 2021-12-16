package com.example.demo.controllers;

import com.example.demo.models.ClientModel;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
  @Autowired
  ClientRepository clienteRepository;

  @GetMapping("/listar")
  public List<ClientModel> listarClientes() {
    return clienteRepository.findAll();
  }

  @PostMapping("/crear")
  public ClientModel crearCliente(ClientModel cliente) {
    return clienteRepository.save(cliente);
  }

  @DeleteMapping(path = "/delete/{id}")
  public String eliminarCliente(@PathVariable("id") Long id) {
    clienteRepository.deleteById(id);
    return "Eliminado";
  }
}