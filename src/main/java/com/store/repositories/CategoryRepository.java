package com.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.models.ProductCategory;

public interface CategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
