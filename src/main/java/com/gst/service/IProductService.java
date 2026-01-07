package com.gst.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gst.dto.request.ProductRequestDTO;
import com.gst.dto.response.ProductResponseDTO;

@Service
public interface IProductService {
	 public ProductResponseDTO save(ProductRequestDTO dto);
	 public List<ProductResponseDTO> get();
	 public ProductResponseDTO get(Long id);
	 public ProductResponseDTO update(Long id, ProductRequestDTO dto);
	 public String delete(Long id);

}
