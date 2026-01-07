package com.gst.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gst.dto.request.BusinessRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.entity.Business;

@Service
public interface IBusinessService {
	public Business save(BusinessRequestDTO dto);

	public BusinessResponseDTO get(Long id);

	public List<BusinessResponseDTO> get();
}
