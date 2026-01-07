package com.gst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gst.common.ApiResponse;
import com.gst.dto.request.ProductRequestDTO;
import com.gst.dto.response.ProductResponseDTO;
import com.gst.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@PostMapping("/products")
	public ResponseEntity<ApiResponse<ProductResponseDTO>> save(@RequestBody ProductRequestDTO dto) {
		ProductResponseDTO product = service.save(dto);
		ApiResponse<ProductResponseDTO> response = new ApiResponse<>("SUCCESS", "Product created successfully",
				product);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/products")
	public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAll() {
		List<ProductResponseDTO> list = service.get();
		ApiResponse<List<ProductResponseDTO>> response = new ApiResponse<>("SUCCESS", "Products fetched successfully",list);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ApiResponse<ProductResponseDTO>> getById(@PathVariable Long id) {
		ProductResponseDTO dto = service.get(id);
		ApiResponse<ProductResponseDTO> response = new ApiResponse<>("SUCCESS", "Product fetched successfully", dto);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<ApiResponse<ProductResponseDTO>> update(@PathVariable Long id, @RequestBody ProductRequestDTO dto) {
		ProductResponseDTO updated = service.update(id, dto);
		ApiResponse<ProductResponseDTO> response = new ApiResponse<>("SUCCESS", "Product updated successfully",updated);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
		service.delete(id);
		ApiResponse<Object> response = new ApiResponse<>("SUCCESS", "Product deleted successfully", null);
		return ResponseEntity.ok(response);
	}
}
