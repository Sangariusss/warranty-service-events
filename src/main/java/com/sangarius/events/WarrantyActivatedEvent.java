package com.sangarius.events;

public class WarrantyActivatedEvent extends DomainEvent {

    private final String productId;
    private final String warrantyId;

    public WarrantyActivatedEvent(String productId, String warrantyId) {
        this.productId = productId;
        this.warrantyId = warrantyId;
    }

    public String getProductId() {
        return productId;
    }

    public String getWarrantyId() {
        return warrantyId;
    }
}
