package com.example.demo.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "estado_orden")
@EntityListeners(AuditingEntityListener.class)
public class StatusModel {
    @Column(name = "Estado", nullable = false)
    private String Estado;

    @Id
    @Column(name = "id_estado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @OneToMany(mappedBy = "estados", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<OrderModel> orden;

    public String getEstado() {
        return this.Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Long getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    @JsonIgnore
    public List<OrderModel> getOrden() {
        return this.orden;
    }

    @JsonProperty
    public void setOrden(List<OrderModel> orden) {
        this.orden = orden;
    }
}
