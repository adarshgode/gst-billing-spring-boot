package com.gst.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.gst.dto.request.BusinessRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.entity.Business;
import com.gst.service.IBusinessService;

@RestController
@RequestMapping("/api")
public class BusinessController {

	@Autowired
	private IBusinessService service;

	@PostMapping("/business")
	public ResponseEntity<ApiResponse<Business>> save(@RequestBody @Valid BusinessRequestDTO dto) {
		Business business = service.save(dto);
		ApiResponse<Business> response = new ApiResponse<>("SUCCESS", "Business created successfully", business);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/business/{id}")
	public ResponseEntity<ApiResponse<BusinessResponseDTO>> getById(@PathVariable Long id) {
		BusinessResponseDTO dto = service.get(id);
		ApiResponse<BusinessResponseDTO> response = new ApiResponse<>("SUCCESS", "Business fetched successfully", dto);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/business")
	public ResponseEntity<ApiResponse<List<BusinessResponseDTO>>> getAll() {
		List<BusinessResponseDTO> list = service.get();
		ApiResponse<List<BusinessResponseDTO>> response = new ApiResponse<>("SUCCESS",
				"Businesses fetched successfully", list);
		return ResponseEntity.ok(response);
	}
}
