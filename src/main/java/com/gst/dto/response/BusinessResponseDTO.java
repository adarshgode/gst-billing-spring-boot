package com.gst.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResponseDTO {
	private Long id;
	private String businessName;
	private String gstNumber;
	private String address;
	private String state;
	private String phone;
	private LocalDateTime createdAt;
}
