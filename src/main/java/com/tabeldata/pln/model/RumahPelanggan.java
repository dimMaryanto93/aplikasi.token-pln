package com.tabeldata.pln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "m_rumah")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RumahPelanggan {

    @NotNull
    @Column(name = "alamat")
    public String alamat;
    @Id
    @GenericGenerator(name = "gen_rumah", strategy = "uuid2")
    @GeneratedValue(generator = "gen_rumah")
    private String id;
    @ManyToOne
    @JoinColumn(name = "id_pelanggan", nullable = false)
    private Pelanggan pelanggan;
    @NotNull
    @Column(name = "rt", nullable = false)
    private Integer rt;

    @NotNull
    @Column(name = "rw", nullable = false)
    private Integer rw;

    @NotEmpty
    @NotNull
    @Column(name = "kelurahan", nullable = false)
    private String kelurahan;

    @NotEmpty
    @NotNull
    @Column(name = "kecamatan", nullable = false)
    private String kecamatan;

    @NotEmpty
    @NotNull
    @Column(name = "kota_kabupaten", nullable = false)
    private String kotaKabupaten;

    @Column(name = "saldo_token", nullable = false)
    private BigDecimal saldoToken;
}
