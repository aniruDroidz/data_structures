package org.anirudroids.machine_coding.parking_lot.models;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private int totalCapacity;
    private List<VehicleType> supportedVehicleTypes;
    private Status parkingLotStatus;
}
