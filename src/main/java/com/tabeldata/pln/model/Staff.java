package com.tabeldata.pln.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "m_staff")
@EqualsAndHashCode(callSuper = false)
public class Staff extends User {

    @Column(name = "nama_staff")
    private String nama;
}
