package com.gst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dto.request.BusinessRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.entity.Business;
import com.gst.mapper.BusinessMapper;
import com.gst.repository.BusinessRepository;

@Service
public class BusinessService implements IBusinessService {
	@Autowired
	public BusinessRepository repository;

	@Override
	public Business save(BusinessRequestDTO dto) {
		return repository.save(BusinessMapper.convertToEntity(dto));
	}

	@Override
	public BusinessResponseDTO get(Long id) {
		Optional<Business> b = repository.findById(id);
		return BusinessMapper.convertToDTO(b.get());
	}

	@Override
	public List<BusinessResponseDTO> get() {
		List<Business> list = repository.findAll();
		List<BusinessResponseDTO> dtoList = new ArrayList<>();
		for(Business b : list) {
			dtoList.add(BusinessMapper.convertToDTO(b));
		}
		return dtoList;
	}
	
}
