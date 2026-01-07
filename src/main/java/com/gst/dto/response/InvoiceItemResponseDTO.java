package com.gst.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemResponseDTO {
	private Long id;
	private Long product;
	private Integer quantity;
	private Double price;
	private Double gstAmount;
	private Double totalAmount;
	private Integer invoice;
}
