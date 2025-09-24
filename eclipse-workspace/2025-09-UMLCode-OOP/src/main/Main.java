package main;

import trucks.*;
import components.Owner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Truck Class UML Demonstration with HAS-A Relationships ===\n");
        
        // Create different types of trucks
        System.out.println("1. Creating Fire Truck:");
        FireTruck fireTruck = new FireTruck(
            6, 1, 2, 4, 120, 800, 250, 350,  // Vehicle parameters
            5000.0f, "Diesel", 450, "Automatic",  // Truck parameters
            2000, 1500, 30, true, true  // FireTruck specific parameters
        );
        
        System.out.println("2. Creating Refrigerated Truck:");
        RefrigeratedTruck refrigeratedTruck = new RefrigeratedTruck(
            6, 1, 2, 4, 100, 600, 240, 300,  // Vehicle parameters
            3000.0f, "Diesel", 350, "Manual",  // Truck parameters
            false, -5.0f  // RefrigeratedTruck specific parameters
        );
        
        System.out.println("3. Creating Flatbed Truck:");
        FlatbedTruck flatbedTruck = new FlatbedTruck(
            6, 1, 2, 4, 110, 700, 250, 320,  // Vehicle parameters
            8000.0f, "Diesel", 400, "Manual",  // Truck parameters
            600, 400, 100,true, "Foam"  // FlatbedTruck specific parameters
        );
        
        System.out.println("4. Creating Dump Truck:");
        DumpTruck dumpTruck = new DumpTruck(
            6, 1, 2, 4, 90, 650, 240, 350,  // Vehicle parameters
            12000.0f, "Diesel", 500, "Automatic",  // Truck parameters
            15, 45  // DumpTruck specific parameters
        );
        
        System.out.println("5. Creating Tanker Truck:");
        TankerTruck tankerTruck = new TankerTruck(
            6, 1, 2, 4, 100, 750, 250, 380,  // Vehicle parameters
            15000.0f, "Diesel", 450, "Automatic",  // Truck parameters
            20000, "Fuel", true  // TankerTruck specific parameters
        );
        
        System.out.println("6. Creating Armored Truck:");
        ArmoredTruck armoredTruck = new ArmoredTruck(
            6, 1, 2, 4, 130, 600, 240, 300,  // Vehicle parameters
            2000.0f, "Diesel", 400, "Automatic",  // Truck parameters
            true, true, true, "Bulletproof Glass"  // ArmoredTruck specific parameters
        );
        
        System.out.println("7. Creating Tow Truck:");
        TowTruck towTruck = new TowTruck(
            6, 1, 2, 4, 110, 650, 240, 320,  // Vehicle parameters
            4000.0f, "Diesel", 350, "Manual",  // Truck parameters
            15, 5000, 100, true, "Boom"  // TowTruck specific parameters
        );
        
        System.out.println("8. Creating Concrete Mixer Truck:");
        ConcreteMixerTruck concreteMixerTruck = new ConcreteMixerTruck(
            6, 1, 2, 4, 80, 700, 250, 350,  // Vehicle parameters
            10000.0f, "Diesel", 400, "Manual",  // Truck parameters
            8.0f, 12, "Hydraulic", 500, 15.0f  // ConcreteMixerTruck specific parameters
        );
        
        System.out.println("9. Creating Trailer Truck:");
        TrailerTruck trailerTruck = new TrailerTruck(
            10, 1, 2, 6, 100, 1600, 250, 400,  // Vehicle parameters
            25000.0f, "Diesel", 500, "Automatic",  // Truck parameters
            2  // TrailerTruck specific parameters
        );
        System.out.println("10. Creating Pickup Truck:");
        PickupTruck pickupTruck = new PickupTruck(4, 40, 4, 3, 500, 5, 4, 2, 100, "Diesel", 500, "Automatic", "Regular", 100, 2, true);
        
        System.out.println("\n=== Demonstrating HAS-A Relationships ===");
        
        // Create owners for demonstration
        Owner fireStationOwner = new Owner("John Smith", "City Fire Department", "FD-001", "555-FIRE");
        Owner constructionOwner = new Owner("Mike Johnson", "ABC Construction", "CON-002", "555-BUILD");
        Owner deliveryOwner = new Owner("Sarah Wilson", "Quick Delivery Co", "DEL-003", "555-FAST");
        
        System.out.println("\n1. Demonstrating Truck HAS-A Owner relationship:");
        System.out.println("Assigning owners to trucks:");
        fireTruck.assignOwner(fireStationOwner);
        dumpTruck.assignOwner(constructionOwner);
        refrigeratedTruck.assignOwner(deliveryOwner);
        
        System.out.println("\n2. Demonstrating Truck HAS-A Engine relationship:");
        System.out.println("Fire Truck Engine Operations:");
        fireTruck.startEngine();
        fireTruck.accelerateEngine();
        fireTruck.decelerateEngine();
        fireTruck.stopEngine();
        
        System.out.println("\n3. Demonstrating Owner functionality:");
        System.out.println("Maintenance reporting:");
        fireTruck.reportMaintenance();
        dumpTruck.reportMaintenance();
        
        System.out.println("\n=== Demonstrating Vehicle Methods ===");
        System.out.println("\nFire Truck Operations:");
        fireTruck.start();
        fireTruck.accelerate();
        fireTruck.brake();
        fireTruck.stop();
        
        System.out.println("\n=== Demonstrating Truck Methods ===");
        System.out.println("\nRefrigerated Truck Operations:");
        refrigeratedTruck.Load();
        refrigeratedTruck.secureLoad();
        refrigeratedTruck.unLoad();
        refrigeratedTruck.removeLoad();
        
        System.out.println("\n=== Demonstrating Specialized Truck Methods ===");
        System.out.println("\nFire Truck Special Operations:");
        fireTruck.sprayWater();
        fireTruck.extendLadder();
        fireTruck.activateSiren(true);
        fireTruck.turnOnEmergencyLights(true);
        
        System.out.println("\nRefrigerated Truck Special Operations:");
        refrigeratedTruck.setTemperature();
        refrigeratedTruck.startFreezing();
        refrigeratedTruck.stopFreezing();
        
        System.out.println("\nFlatbed Truck Special Operations:");
        flatbedTruck.lowerBed();
        flatbedTruck.raiseBed();
        flatbedTruck.secureCargo();
        flatbedTruck.releaseCargo();
        
        System.out.println("\nDump Truck Special Operations:");
        dumpTruck.dumpLoad();
        dumpTruck.raiseBed();
        
        System.out.println("\nTanker Truck Special Operations:");
        tankerTruck.pumpLiquid();
        tankerTruck.stopPumping();
        
        System.out.println("\nArmored Truck Special Operations:");
        armoredTruck.activateAlarm();
        armoredTruck.lockDoors();
        
        System.out.println("\nTow Truck Special Operations:");
        towTruck.extendBoom();
        towTruck.retractBoom();
        towTruck.towVehicle();
        
        System.out.println("\nConcrete Mixer Truck Special Operations:");
        concreteMixerTruck.startMixing();
        concreteMixerTruck.stopMixing();
        concreteMixerTruck.dischargeConcrete();
        
        System.out.println("\nTrailer Truck Special Operations:");
        trailerTruck.attachTrailer();
        trailerTruck.detachTrailer();

        System.out.println("\nPickup Truck Special Operations: ");
        pickupTruck.towLoad();
        pickupTruck.openBed();
        pickupTruck.closeBed();
        pickupTruck.switchDriveMode();
        
        System.out.println("\n=== Demonstration Complete ===");
    }
}