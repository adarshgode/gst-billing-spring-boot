package com.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gst.common.ApiResponse;
import com.gst.dto.request.InvoiceRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.dto.response.InvoiceResponseDTO;
import com.gst.service.InvoiceService;

@RestController
@RequestMapping("/api")
public class InvoiceController {
	@Autowired
	private InvoiceService service;

	@PostMapping("/invoices")
	public ResponseEntity<ApiResponse<InvoiceResponseDTO>> save(@RequestBody InvoiceRequestDTO dto) {
		InvoiceResponseDTO invoice = service.save(dto);
		ApiResponse<InvoiceResponseDTO> response = new ApiResponse<>("SUCCESS", "Invoice created successfully",
				invoice);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/invoices/{id}")
	public ResponseEntity<ApiResponse<InvoiceResponseDTO>> getById(@PathVariable Integer id) {
		InvoiceResponseDTO dto = service.get(id);
		ApiResponse<InvoiceResponseDTO> response = new ApiResponse<>("SUCCESS", "Invoice fetched successfully", dto);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/invoices")
	public ResponseEntity<ApiResponse<List<InvoiceResponseDTO>>> getAll() {
		List<InvoiceResponseDTO> list = service.get();
		ApiResponse<List<InvoiceResponseDTO>> response = new ApiResponse<>("SUCCESS", "Invoices fetched successfully",
				list);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/invoices/business/{businessId}")
	public ResponseEntity<ApiResponse<BusinessResponseDTO>> getByBusinessId(@PathVariable Long businessId) {
		BusinessResponseDTO dto = service.getByBusinessId(businessId);
		ApiResponse<BusinessResponseDTO> response = new ApiResponse<>("SUCCESS",
				"Invoices fetched for business successfully", dto);
		return ResponseEntity.ok(response);
	}
}
