package com.gst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gst.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
