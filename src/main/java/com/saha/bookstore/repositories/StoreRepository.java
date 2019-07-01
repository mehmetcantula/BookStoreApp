package com.saha.bookstore.repositories;

import com.saha.bookstore.model.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {
}
