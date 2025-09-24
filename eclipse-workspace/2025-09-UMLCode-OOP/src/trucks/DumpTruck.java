package trucks;

public class DumpTruck extends Truck{

    private int dumpBedVolume, dumpBedAngle;


    public DumpTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height,
              float maxLoadCapacity, String fuelType, int horsePower, String transmission, int dumpBedVolume, int dumpBedAngle) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower,
                transmission);
        //TODO Auto-generated constructor stub

        this.dumpBedVolume = dumpBedVolume;
        this.dumpBedAngle = dumpBedAngle;
    }
    public void dumpLoad(){
        System.out.println("Dumping Load");
    }
    
    public void raiseBed(){
        System.out.println("Raising Bed");
    }
    public void lowerBed(){
        System.out.println("Lowering Bed");
    }
}