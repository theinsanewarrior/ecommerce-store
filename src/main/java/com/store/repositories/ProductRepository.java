	package com.store.repositories;
import java.util.*;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Transactional
	@Modifying
	@Query("update Product p set p.stock=p.stock-:qty where p.pid=:pid")
	void updateCopies(@Param("qty") int qty,@Param("pid") int pid);
	@Query("from Product p where p.stock=0")
	List<Product> getOutOfStock();
	List<Product> findByBrand(String brand);
	List<Product> findByName(String name);
	List<Product> findByCategory(String category);
	List<Product> findByPid(int pid);
}
