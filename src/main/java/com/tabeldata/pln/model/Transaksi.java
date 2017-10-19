package com.tabeldata.pln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_transaksi")
public class Transaksi {

    @Id
    @GenericGenerator(name = "gen_transaksi", strategy = "uuid2")
    @GeneratedValue(generator = "gen_transaksi")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_rumah", nullable = false)
    private RumahPelanggan rumahPelanggan;

    @Column(name = "waktu_bayar", nullable = false)
    private Timestamp waktuBayar;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "jumlah_bayar", nullable = false)
    private BigDecimal bayar;
}
