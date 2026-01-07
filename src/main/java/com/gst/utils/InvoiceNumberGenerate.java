package com.gst.utils;

import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;

public class InvoiceNumberGenerate {
	 private static final AtomicInteger counter = new AtomicInteger(1);

	    public static String generateInvoiceNumber() {

	        int currentYear = Year.now().getValue();
	        int number = counter.getAndIncrement();

	        // Always 6 digits (000001, 000002, ...)
	        String formattedNumber = String.format("%06d", number);

	        return "INV-" + currentYear + "-" + formattedNumber;
	    }
}
