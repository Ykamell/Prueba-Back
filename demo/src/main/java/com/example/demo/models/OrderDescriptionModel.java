package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "descripcion_orden")
@EntityListeners(AuditingEntityListener.class)
public class OrderDescriptionModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", nullable = false)
    @JsonBackReference
    @JsonIgnore
    private OrderModel n_orden;

    @Id
    @Column(name = "id_item", nullable = false)
    private Long idItem;

    @Column(name = "Ancho", nullable = false)
    private Integer Ancho;

    @Column(name = "Largo", nullable = false)
    private Integer Largo;

    @JsonIgnore
    public OrderModel getN_orden() {
        return this.n_orden;
    }

    @JsonProperty
    public void setN_orden(OrderModel n_orden) {
        this.n_orden = n_orden;
    }

    public Long getIdItem() {
        return this.idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Integer getAncho() {
        return this.Ancho;
    }

    public void setAncho(Integer Ancho) {
        this.Ancho = Ancho;
    }

    public Integer getLargo() {
        return this.Largo;
    }

    public void setLargo(Integer Largo) {
        this.Largo = Largo;
    }

}
