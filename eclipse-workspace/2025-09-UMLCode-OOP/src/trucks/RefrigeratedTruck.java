package trucks;

public class RefrigeratedTruck extends Truck{

    private boolean isFrozen;
    private float temperature;


    public RefrigeratedTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height,
                      float maxLoadCapacity, String fuelType, int horsePower, String transmission, boolean isFrozen, float temperature) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower,
                transmission);

        this.isFrozen = isFrozen;
        this.temperature = temperature;
    }
    public void setTemperature(){
        System.out.println("Setting Temperature");
    }
    public void startFreezing(){
        System.out.println("Start Freezing");
    }
    public void stopFreezing(){
        System.out.println("Stop Freezing");
    }

}
