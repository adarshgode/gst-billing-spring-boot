package com.gst.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gst.entity.Business;
@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
