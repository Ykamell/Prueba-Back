package com.example.demo.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "clientes")
@EntityListeners(AuditingEntityListener.class)
public class ClientModel {

    @Column(name = "Nombre", nullable = false)
    private String Nombre;

    @Column(name = "Direccion", nullable = false)
    private String Direccion;

    @Column(name = "Telefono", nullable = false)
    private Integer Telefono;

    @Column(name = "Nacionalidad", nullable = false)
    private String Nacionalidad;

    @Column(name = "Correo", nullable = false)
    private String Correo;

    @Id
    @Column(name = "id_cliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(nullable = true)
    @JsonManagedReference
    @JsonIgnore
    private List<OrderModel> orden;

    @JsonIgnore
    public List<OrderModel> getOrden() {
        return this.orden;
    }

    @JsonProperty
    public void setOrden(List<OrderModel> orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    public String getNacionalidad() {
        return this.Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getCorreo() {
        return this.Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
