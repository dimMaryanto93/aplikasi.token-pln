package com.tabeldata.pln.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "m_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GenericGenerator(name = "gen_user", strategy = "uuid2")
    @GeneratedValue(generator = "gen_user")
    private String id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String username;

    @Column(name = "passwd", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean active;
}
