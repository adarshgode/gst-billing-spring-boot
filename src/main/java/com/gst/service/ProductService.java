package com.gst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.dto.request.ProductRequestDTO;
import com.gst.dto.response.ProductResponseDTO;
import com.gst.entity.Product;
import com.gst.mapper.ProductMapper;
import com.gst.repository.ProductRepository;

@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductRepository repository;
	
	@Override
	public ProductResponseDTO save(ProductRequestDTO dto) {
		return ProductMapper.convertToDTO(repository.save(ProductMapper.convertToEntity(dto)));
	}

	@Override
	public List<ProductResponseDTO> get() {
		List<Product> list = repository.findAll();
		List<ProductResponseDTO> result = new ArrayList<>();
		for(Product p : list) {
			result.add(ProductMapper.convertToDTO(p));
		}
		return result;
	}

	@Override
	public ProductResponseDTO get(Long id) {
		Optional<Product> p = repository.findById(id);
		return ProductMapper.convertToDTO(p.get());
	}

	@Override
	public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
		Optional<Product> op = repository.findById(id);
		Product p  = op.get();
		if(dto.getGstPercentage() != null) {
			p.setGstPercentage(dto.getGstPercentage());
		}
		if(dto.getPrice() != null) {
			p.setPrice(dto.getPrice());
		}
		if(dto.getProductName() != null) {
			p.setProductName(dto.getProductName());
		}
		repository.save(p);
		return ProductMapper.convertToDTO(p);
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return "Data Deleted";
	}

}
