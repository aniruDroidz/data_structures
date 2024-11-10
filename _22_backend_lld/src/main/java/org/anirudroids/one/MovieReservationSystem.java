package org.anirudroids.one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MovieReservationSystem {
    private int availableSeats;
    private final Lock reservationLock;

    public MovieReservationSystem(int totalSeats) {
        reservationLock = new ReentrantLock(true);
        availableSeats = totalSeats;
    }

    //TODO: Implement this method and try to book numSeats number of movie tickets
    public boolean reserveSeats(int numSeats) {

        try {
            reservationLock.lock();
            if (availableSeats < numSeats) {
                availableSeats -= numSeats;
            } else {
                return false;
            }
        } finally {
            reservationLock.unlock();
        }

        return true;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

}