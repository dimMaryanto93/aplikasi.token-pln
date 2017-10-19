package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff, String> {

    Staff findByUsername(String username);
}
