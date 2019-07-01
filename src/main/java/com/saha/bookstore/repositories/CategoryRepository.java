package com.saha.bookstore.repositories;

import com.saha.bookstore.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
