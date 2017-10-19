package com.tabeldata.pln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_pelanggan")
public class Pelanggan {

    @Id
    @GenericGenerator(name = "gen_pelanggan", strategy = "uuid2")
    @GeneratedValue(generator = "gen_pelanggan")
    @Column(name = "id_pelanggan", length = 120)
    private String id;

    @NotNull
    @NotEmpty
    @Column(name = "nama_pelanggan")
    private String nama;


    @NotEmpty
    @NotNull
    @Column(name = "nomor_ktp", length = 64, nullable = false, unique = true)
    private String nomorKtp;
}
