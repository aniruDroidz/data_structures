package org.anirudroids.machine_coding.parking_lot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private String id;
    private int totalAmount;
    private Date exitTime;
    private Ticket ticket;
    private List<Payment> payments;
    private Gate exitGate;
    private Operator operator;
}
