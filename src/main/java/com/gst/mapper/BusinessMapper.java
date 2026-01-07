package com.gst.mapper;

import com.gst.dto.request.BusinessRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.entity.Business;

public class BusinessMapper {
	public static Business convertToEntity(BusinessRequestDTO dto) {
		Business b = new Business();
		b.setPhone(dto.getPhone());
		b.setBusinessName(dto.getBusinessName());
		b.setCreatedAt(dto.getCreatedAt());
		b.setGstNumber(dto.getGstNumber());
		b.setAddress(dto.getAddress());
		b.setState(dto.getState());
		
		return b;
	}
	
	public static BusinessResponseDTO convertToDTO(Business b) {
		BusinessResponseDTO dto = new BusinessResponseDTO();
		dto.setId(b.getId());
		dto.setAddress(b.getAddress());
		dto.setBusinessName(b.getBusinessName());
		dto.setCreatedAt(b.getCreatedAt());
		dto.setGstNumber(b.getGstNumber());
		dto.setPhone(b.getPhone());
		dto.setState(b.getState());
		return dto;
	}
}
