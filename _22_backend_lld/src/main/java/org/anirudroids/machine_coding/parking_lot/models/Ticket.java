package org.anirudroids.machine_coding.parking_lot.models;

import java.util.Date;

public class Ticket extends BaseModel {
    private String id;
    private String type;
    private VehicleType vehicleType;

    private Vehicle vehicle;
    private Date date;
    private ParkingSlot parkingSlot;
    private Operator operator;
    private Gate entryGate;

}
