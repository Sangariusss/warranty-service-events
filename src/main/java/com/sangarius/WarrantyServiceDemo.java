package com.sangarius;

import com.sangarius.aggregates.WarrantyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarrantyServiceDemo {

    private static final Logger logger = LoggerFactory.getLogger(WarrantyServiceDemo.class);

    public static void main(String[] args) {
        WarrantyService warrantyService = new WarrantyService("W98765");

        warrantyService.activateWarranty("P12345");

        logger.info("----------------------------------------");

        warrantyService.submitClaim("P12345", "C54321");
    }
}
