package org.anirudroids.machine_coding.parking_lot.service;

import org.anirudroids.machine_coding.parking_lot.models.Ticket;
import org.anirudroids.machine_coding.parking_lot.models.VehicleType;

public class TicketService {
    public Ticket issueTicket(String licensePlate, String ownerName, VehicleType vehicleType, int gateId) {
        return new Ticket();
    }
}
