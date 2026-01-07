package com.gst.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessRequestDTO {
	@NotNull
	@NotEmpty
	private String businessName;
	@Size(min=15, max=15)
	private String gstNumber;
	private String address;
	private String state;
	private String phone;
	private LocalDateTime createdAt = LocalDateTime.now();
}
