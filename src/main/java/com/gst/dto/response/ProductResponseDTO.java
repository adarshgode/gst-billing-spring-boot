package com.gst.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
	private Long id;
	private String productName;
	private Double price;
	private Double gstPercentage;
	private LocalDateTime createdAt;
}
