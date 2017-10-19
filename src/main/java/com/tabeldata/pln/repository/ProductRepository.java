package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    List<Product> findAll();

    @Transactional(readOnly = false)
    @Modifying
    @Query("update Product set harga = ?1 where id = ?2")
    void setHargaById(BigDecimal price, String kode);
}
