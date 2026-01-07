package com.gst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gst.dto.request.InvoiceItemRequestDTO;
import com.gst.dto.request.InvoiceRequestDTO;
import com.gst.dto.response.BusinessResponseDTO;
import com.gst.dto.response.InvoiceResponseDTO;
import com.gst.entity.Business;
import com.gst.entity.Invoice;
import com.gst.entity.InvoiceItem;
import com.gst.entity.Product;
import com.gst.exception.ResourceNotFoundException;
import com.gst.mapper.BusinessMapper;
import com.gst.mapper.InvoiceMapper;
import com.gst.repository.BusinessRepository;
import com.gst.repository.InvoiceRepository;
import com.gst.repository.ProductRepository;
import com.gst.utils.InvoiceNumberGenerate;

@Service
public class InvoiceService implements IInvoiceService{
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private BusinessRepository businessRepo;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO dto) {
		Business b = businessRepo.findById(dto.getBusinessId())
		        .orElseThrow(() -> new RuntimeException("Business not found"));

//		String customerState = dto.getCustomerState();
		List<InvoiceItem> invoiceItems = new ArrayList<>();
		Double totalGst = 0.0;
		Double grandTotal = 0.0;
		Double totalAmount = 0.0;
		
		Invoice invoice = new Invoice();
		invoice.setBusiness(b);
		invoice.setInvoiceDate(LocalDate.now());
		invoice.setInvoiceNumber(InvoiceNumberGenerate.generateInvoiceNumber());
		
		for(InvoiceItemRequestDTO item : dto.getItems()) {
			Product p = productRepo.findById(item.getProductId())
			        .orElseThrow(() -> new RuntimeException("Product not found"));
			InvoiceItem i = new InvoiceItem();
			i.setQuantity(item.getQuantity());
			i.setPrice(p.getPrice());
			
			i.setGstAmount( (p.getGstPercentage() * i.getPrice() * i.getQuantity() ) / 100);
			i.setTotalAmount( i.getPrice() * i.getQuantity() + i.getGstAmount() );
			// invoice is remaining
			i.setInvoice(invoice);
			i.setProduct(p);
			
			totalGst += i.getGstAmount();
			totalAmount += i.getPrice() * i.getQuantity();
			grandTotal += i.getTotalAmount();
			
			invoiceItems.add(i);
		}
		
		invoice.setItems(invoiceItems);
		invoice.setTotalGST(totalGst);
		invoice.setGrandTotal(grandTotal);
		invoice.setTotalAmount(totalAmount);
		
		return InvoiceMapper.convertToDTO(invoiceRepo.save(invoice));
	}

	@Transactional(readOnly = true)
	public InvoiceResponseDTO get(Integer id) {
		return InvoiceMapper.convertToDTO(invoiceRepo.findById(id).get());
	}

	@Transactional(readOnly = true)
	public List<InvoiceResponseDTO> get() {
		List<Invoice> list = invoiceRepo.findAllWithItems();
		List<InvoiceResponseDTO> result = new ArrayList<>();
		for(Invoice i : list) {
			result.add(InvoiceMapper.convertToDTO(i));
		}
		return result;
	}

	public BusinessResponseDTO getByBusinessId(Long businessId) {
		Business b = businessRepo.findById(businessId)
		        .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return BusinessMapper.convertToDTO(b);
	}
}
