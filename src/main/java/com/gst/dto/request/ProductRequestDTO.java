package com.gst.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
	@Min(1)
	private String productName;
	private Double price;
	private Double gstPercentage;
	private LocalDateTime createdAt = LocalDateTime.now();
}
