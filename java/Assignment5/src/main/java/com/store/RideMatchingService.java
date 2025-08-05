package com.store;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class RideMatchingService {
    private final List<Driver> drivers;
    private final Semaphore driverSemaphore;
    private final ReentrantLock lock;

    public RideMatchingService(List<Driver> drivers) {
        this.drivers = drivers;
        this.driverSemaphore = new Semaphore(drivers.size());
        this.lock = new ReentrantLock();
    }

    public void matchPassenger(Passenger passenger) {
        try {
            driverSemaphore.acquire(); // wait for an available driver

            lock.lock();
            for (Driver driver : drivers) {
                if (driver.isAvailable()) {
                    driver.assign();
                    System.out.println("Passenger " + passenger.getId() + " → Driver " + driver.getName());
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
