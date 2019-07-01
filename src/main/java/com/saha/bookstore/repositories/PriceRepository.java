package com.saha.bookstore.repositories;

import com.saha.bookstore.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}
