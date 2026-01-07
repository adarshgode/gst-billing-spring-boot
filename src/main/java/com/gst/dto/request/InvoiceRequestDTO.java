package com.gst.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDTO {
	private Long businessId;
	private String customerState;
	private List<InvoiceItemRequestDTO> items;
}
