package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.Transaksi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, String> {
}
