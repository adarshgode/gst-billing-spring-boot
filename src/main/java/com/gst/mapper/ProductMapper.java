package com.gst.mapper;

import com.gst.dto.request.ProductRequestDTO;
import com.gst.dto.response.ProductResponseDTO;
import com.gst.entity.Product;
import com.gst.exception.InvalidInputException;
import com.gst.utils.Allowed_GST;

public class ProductMapper {
	public static Product convertToEntity(ProductRequestDTO dto) {
		Product p = new Product();
		p.setProductName(dto.getProductName());
		p.setPrice(dto.getPrice());
		p.setCreatedAt(dto.getCreatedAt());
		Double gst = dto.getGstPercentage();
		if(Allowed_GST.ALLOWED_GST.contains(gst)) {
			p.setGstPercentage(gst);
		}else {
			throw new InvalidInputException("GST Percentage not Allowed Exception");
		}
		return p;
	}

	public static ProductResponseDTO convertToDTO(Product p) {
		ProductResponseDTO dto = new ProductResponseDTO();
		dto.setCreatedAt(p.getCreatedAt());
		dto.setGstPercentage(p.getGstPercentage());
		dto.setId(p.getId());
		dto.setPrice(p.getPrice());
		dto.setProductName(p.getProductName());
		return dto;
	}
	
}
