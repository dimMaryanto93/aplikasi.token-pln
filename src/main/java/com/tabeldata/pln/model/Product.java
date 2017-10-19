package com.tabeldata.pln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_product")
public class Product {

    @Id
    @Column(name = "kode_product", nullable = false, unique = true)
    private String id;

    @Column(name = "nama_product", nullable = false)
    private String namaProduct;

    @Column(name = "harga_product", nullable = false)
    private BigDecimal harga;
}
