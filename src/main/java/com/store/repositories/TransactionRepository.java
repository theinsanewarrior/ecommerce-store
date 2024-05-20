package com.store.repositories;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.store.models.ProductTransaction;

public interface TransactionRepository extends JpaRepository<ProductTransaction, String> {
	List<ProductTransaction> findByUid(String uid);
}
