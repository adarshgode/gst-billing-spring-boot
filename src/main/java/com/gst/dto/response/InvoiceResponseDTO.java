package com.gst.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
	private Integer id;
	private String invoiceNumber;
	private LocalDate invoiceDate;
	private Double totalAmount;
	private Double totalGST;
	private Double grandTotal;
	private Long business;
    private List<InvoiceItemResponseDTO> items;
}
