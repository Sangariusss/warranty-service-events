package com.sangarius.events;

public class WarrantyClaimSubmittedEvent extends DomainEvent {

    private final String productId;
    private final String claimId;

    public WarrantyClaimSubmittedEvent(String productId, String claimId) {
        this.productId = productId;
        this.claimId = claimId;
    }

    public String getProductId() {
        return productId;
    }

    public String getClaimId() {
        return claimId;
    }
}
