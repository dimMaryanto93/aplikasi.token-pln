package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
}
