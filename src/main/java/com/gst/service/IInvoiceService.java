package com.gst.service;

import org.springframework.stereotype.Service;

import com.gst.dto.request.InvoiceRequestDTO;
import com.gst.dto.response.InvoiceResponseDTO;

@Service
public interface IInvoiceService {
	public InvoiceResponseDTO save(InvoiceRequestDTO dto);
	public InvoiceResponseDTO get(Integer id);
}
