package com.gst.mapper;

import java.util.ArrayList;
import java.util.List;

import com.gst.dto.response.InvoiceItemResponseDTO;
import com.gst.dto.response.InvoiceResponseDTO;
import com.gst.entity.Invoice;
import com.gst.entity.InvoiceItem;

public class InvoiceMapper {
	public static InvoiceResponseDTO convertToDTO(Invoice inv) {
		InvoiceResponseDTO dto = new InvoiceResponseDTO();
		dto.setBusiness(inv.getBusiness().getId());
		dto.setGrandTotal(inv.getGrandTotal());
		dto.setId(inv.getId());
		dto.setTotalGST(inv.getTotalGST());
		dto.setInvoiceDate(inv.getInvoiceDate());
		dto.setInvoiceNumber(inv.getInvoiceNumber());
		dto.setTotalAmount(inv.getTotalAmount());
		List<InvoiceItemResponseDTO> list  = new ArrayList<>();
		for(InvoiceItem item : inv.getItems()) {
			list.add(InvoiceItemMapper.convertToDTO(item));
		}
		dto.setItems(list);
		
		return dto;
	}
}
