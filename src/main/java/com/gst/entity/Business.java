package com.gst.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String businessName;
	private String gstNumber;
	private String address;
	private String state;
	private String phone;
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
	List<Invoice> invoices;
}
