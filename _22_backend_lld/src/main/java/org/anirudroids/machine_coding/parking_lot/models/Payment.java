package org.anirudroids.machine_coding.parking_lot.models;

public class Payment extends BaseModel {
    private int amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
    private Bill bill;
    private PaymentStatus status;
}
