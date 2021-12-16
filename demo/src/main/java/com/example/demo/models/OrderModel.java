package com.example.demo.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ordenes")
@EntityListeners(AuditingEntityListener.class)
public class OrderModel {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    private StatusModel estados;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private ClientModel clientes;

    @Column(name = "n_items", nullable = false)
    private Integer n_items;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Fecha", nullable = false)
    private Date Fecha;

    @Id
    @Column(name = "id_orden", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;

    @OneToMany(mappedBy = "n_orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private List<OrderDescriptionModel> desc_orden;

    @PrePersist
    private void onCreate() {
        Fecha = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        Fecha = new Date();
    }

    public Integer getN_items() {
        return this.n_items;
    }

    public void setN_items(Integer n_items) {
        this.n_items = n_items;
    }

    @JsonIgnore
    public List<OrderDescriptionModel> getDesc_orden() {
        return this.desc_orden;
    }

    @JsonProperty
    public void setDesc_orden(List<OrderDescriptionModel> desc_orden) {
        this.desc_orden = desc_orden;
    }

    public StatusModel getEstados() {
        return this.estados;
    }

    public void setEstados(StatusModel estados) {
        this.estados = estados;
    }

    public ClientModel getClientes() {
        return this.clientes;
    }

    public void setClientes(ClientModel clientes) {
        this.clientes = clientes;
    }

    public Date getFecha() {
        return this.Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Long getIdOrden() {
        return this.idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public void addAttribute(String string, Optional<OrderModel> findById) {
    }

}
