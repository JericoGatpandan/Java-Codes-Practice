package trucks;

public class TankerTruck extends Truck{

    private int tankCapacity;
    private String tankMaterial, pumpType, cargoType;
    private int numberOfCompartments;
    private float pressureRating;

    public TankerTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height, 
                float maxLoadCapacity, String fuelType, int horsePower, String transmission, int tankCapacity, String cargoType, boolean hasPump){
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower, transmission);

        this.tankCapacity = tankCapacity;
        this.cargoType = cargoType;
    }

    void fillTank(){
        System.out.println("Filling Tank...");
        System.out.println("Tank Filled.");
    }

    void emptyTank(){
        System.out.println("Tank Successfully Emptied.");
    }

    public void pumpLiquid(){
        System.out.println("Pumping Liquid...");
    }

    public void stopPumping(){
        System.out.println("Stopping Pump");
    }
}