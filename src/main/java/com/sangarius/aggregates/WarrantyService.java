package com.sangarius.aggregates;

import com.sangarius.events.WarrantyActivatedEvent;
import com.sangarius.events.WarrantyClaimSubmittedEvent;
import com.sangarius.services.DomainEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarrantyService {

    private static final Logger logger = LoggerFactory.getLogger(WarrantyService.class);

    private final String warrantyId;
    private boolean isWarrantyActive;
    private boolean isClaimSubmitted;

    public WarrantyService(String warrantyId) {
        this.warrantyId = warrantyId;
        this.isWarrantyActive = false;
        this.isClaimSubmitted = false;
    }

    public void activateWarranty(String productId) {
        if (!isWarrantyActive) {
            this.isWarrantyActive = true;
            WarrantyActivatedEvent event = new WarrantyActivatedEvent(productId, this.warrantyId);
            DomainEventPublisher.publish(event);
            logger.info("Warranty activated for product ID: {}", productId);
        } else {
            logger.warn("Warranty already activated.");
        }
    }

    public void submitClaim(String productId, String claimId) {
        if (isWarrantyActive && !isClaimSubmitted) {
            this.isClaimSubmitted = true;
            WarrantyClaimSubmittedEvent event = new WarrantyClaimSubmittedEvent(productId, claimId);
            DomainEventPublisher.publish(event);
            logger.info("Warranty claim submitted for product ID: {} with claim ID: {}", productId, claimId);
        } else if (!isWarrantyActive) {
            logger.error("Warranty is not active, cannot submit claim.");
        } else {
            logger.warn("Claim already submitted.");
        }
    }
}
