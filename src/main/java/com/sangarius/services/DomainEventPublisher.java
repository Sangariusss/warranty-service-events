package com.sangarius.services;

import com.sangarius.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(DomainEventPublisher.class);

    private DomainEventPublisher() {
        throw new UnsupportedOperationException("Utility class, cannot be instantiated");
    }

    public static void publish(DomainEvent event) {
        logger.info("Event published: {} (timestamp: {})", event.getClass().getSimpleName(), event.getOccurredOn());

        if (event instanceof WarrantyActivatedEvent activatedEvent) {
            logger.info("-> Generating electronic warranty certificate for product ID: {} (warranty ID: {})",
                activatedEvent.getProductId(), activatedEvent.getWarrantyId());
        } else if (event instanceof WarrantyClaimSubmittedEvent claimEvent) {
            logger.info("-> Sending warranty claim request for product ID: {} (claim ID: {})",
                claimEvent.getProductId(), claimEvent.getClaimId());
        }
    }
}
