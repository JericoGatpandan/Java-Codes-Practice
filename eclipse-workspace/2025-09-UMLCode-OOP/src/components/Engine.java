package components;

public class Engine {
    private String engineType;
    private int horsePower;
    private String fuelType;
    private boolean isRunning;
    private int rpm;

    public Engine(String engineType, int horsePower, String fuelType) {
        this.engineType = engineType;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
        this.isRunning = false;
        this.rpm = 0;
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            rpm = 800; // idle RPM
            System.out.println("Engine started - " + engineType + " running at " + rpm + " RPM");
        } else {
            System.out.println("Engine is already running");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            rpm = 0;
            System.out.println("Engine stopped");
        } else {
            System.out.println("Engine is already stopped");
        }
    }

    public void accelerate() {
        if (isRunning) {
            rpm += 500;
            System.out.println("Engine RPM increased to " + rpm);
        } else {
            System.out.println("Cannot accelerate - engine is not running");
        }
    }

    public void decelerate() {
        if (isRunning && rpm > 800) {
            rpm -= 500;
            System.out.println("Engine RPM decreased to " + rpm);
        } else if (isRunning) {
            System.out.println("Engine at minimum RPM");
        } else {
            System.out.println("Engine is not running");
        }
    }

    // Getters
    public String getEngineType() { return engineType; }
    public int getHorsePower() { return horsePower; }
    public String getFuelType() { return fuelType; }
    public boolean isRunning() { return isRunning; }
    public int getRpm() { return rpm; }

    // Setters
    public void setRpm(int rpm) { 
        if (isRunning) {
            this.rpm = rpm;
        }
    }
}