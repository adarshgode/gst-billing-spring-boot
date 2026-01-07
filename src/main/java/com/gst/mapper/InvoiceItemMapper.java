package com.gst.mapper;

import com.gst.dto.response.InvoiceItemResponseDTO;
import com.gst.entity.InvoiceItem;

public class InvoiceItemMapper {
	public static InvoiceItemResponseDTO convertToDTO(InvoiceItem i) {
		InvoiceItemResponseDTO dto = new InvoiceItemResponseDTO();
		dto.setGstAmount(i.getGstAmount());
		dto.setId(i.getId());
		dto.setInvoice(i.getInvoice().getId());
		dto.setPrice(i.getPrice());
		dto.setQuantity(i.getQuantity());
		dto.setProduct(i.getProduct().getId());
		dto.setTotalAmount(i.getTotalAmount());
		return dto;
	}
}
