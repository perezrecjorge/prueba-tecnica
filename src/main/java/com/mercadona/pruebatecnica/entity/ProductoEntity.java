package com.mercadona.pruebatecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoProducto;

    private String nombre;

    private Integer cantidad;

}
