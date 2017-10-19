package com.tabeldata.pln.repository;

import com.tabeldata.pln.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
    User findByUsername(String user);
}
