package main;

public class Vehicle {
    private int numberOfWheels,steering, chair, mirror, maxSpeed, length, width, height;

    protected Vehicle(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height) {
        this.numberOfWheels = numberOfWheels;
        this.steering = steering;
        this.chair = chair;
        this.mirror = mirror;
        this.maxSpeed = maxSpeed;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void start() {
        System.out.println("Starting...");
    }
    public void stop() {
        System.out.println("Stoping...");
    }
    public void accelerate() {
        System.out.println("Accelerating...");
    }
    public void brake() {
        System.out.println("Braking...");
    }
}