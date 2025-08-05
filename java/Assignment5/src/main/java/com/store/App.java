package com.store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Create 10 drivers
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            drivers.add(new Driver("Driver " + (char) ('A' + i)));
        }

        // Create ride-matching service
        RideMatchingService service = new RideMatchingService(drivers);

        // Prepare executor and latch
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(20); // 20 passengers

        // Create 20 passenger threads
        for (int i = 1; i <= 20; i++) {
            int passengerId = i;
            executor.submit(() -> {
                Passenger p = new Passenger(passengerId);
                service.matchPassenger(p);
                latch.countDown();
            });
        }

        latch.await(); // Wait for all passengers to attempt match
        executor.shutdown();
    }
}
