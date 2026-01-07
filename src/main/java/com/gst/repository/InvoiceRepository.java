package com.gst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gst.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	@Query("SELECT DISTINCT i FROM Invoice i LEFT JOIN FETCH i.items")
			public List<Invoice> findAllWithItems();
}
