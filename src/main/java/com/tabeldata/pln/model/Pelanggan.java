package com.tabeldata.pln.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "m_pelanggan")
@EqualsAndHashCode(callSuper = false)
public class Pelanggan extends User {

    @NotNull
    @NotEmpty
    @Column(name = "nama_pelanggan")
    private String nama;

    @NotEmpty
    @NotNull
    @Column(name = "nomor_ktp", length = 64, nullable = false, unique = true)
    private String nomorKtp;
}
