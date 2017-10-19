package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.Pelanggan;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PelangganRepository extends PagingAndSortingRepository<Pelanggan, String> {
    List<Pelanggan> findAll();
}
