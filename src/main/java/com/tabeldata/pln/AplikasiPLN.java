package com.tabeldata.pln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AplikasiPLN {

    public static void main(String[] args) {
        SpringApplication.run(AplikasiPLN.class, args);
    }
}
