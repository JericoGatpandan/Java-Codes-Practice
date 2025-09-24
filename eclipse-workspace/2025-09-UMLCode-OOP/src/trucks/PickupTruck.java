package trucks;

public class PickupTruck extends Truck{
    private String CabType;
    private int towingCapacity;
    private float bedLength;
    private boolean hasFourWheelDrive;

    public PickupTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height,
                       float maxLoadCapacity, String fuelType, int horsePower, String transmission, String cabType, int towingCapacity, float bedLength, boolean hasFourWheelDrive) {
        super (numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower, transmission);
        this.bedLength = bedLength;
        this.towingCapacity = towingCapacity;
        this.CabType = CabType;
        this.hasFourWheelDrive = hasFourWheelDrive;
    }

    public void towLoad(){
        System.out.println("Attaching...");
    }
    public void openBed (){
        System.out.println("Bed Opened.");
    }
    public void closeBed (){
        System.out.println("Bed Closed.");
    }
    public void switchDriveMode (){
        System.out.println("Switching Modes....");
    }

}
