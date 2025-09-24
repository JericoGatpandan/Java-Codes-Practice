package trucks;

public class TowTruck extends Truck{

    private int winchCapacity, numberOfHooks;
    private boolean hasWheelLift;
    private float boomLength;
    private String towType;


    public TowTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width,
             int height, float maxLoadCapacity, String fuelType, int horsePower, String transmission,
             int winchCapacity, int numberOfHooks, float boomLength, boolean hasWheelLift, String towType) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower,
                transmission);
        //TODO Auto-generated constructor stub

        this.winchCapacity = winchCapacity;
        this.boomLength = boomLength;
        this.hasWheelLift = hasWheelLift;
        this.numberOfHooks = numberOfHooks;
        this.towType = towType;
    }

    public void extendBoom(){
        System.out.println("Extending Boom");
    }
    
    public void retractBoom(){
        System.out.println("Retracting Boom");
    }
    
    public void towVehicle(){
        System.out.println("Towing Vehicle");
    }

    void hookVehicle(){
        System.out.println("Hooking Vehicle");
    }
    void liftVehicle(){
        System.out.println("Lifting Vehicle");
    }
    void lowerVehicle(){
        System.out.println("Lowering Vehicle");
    }
    void operateWinch(){
        System.out.println("Operating Winch");
    }
    void secureCargo(){
        System.out.println("Securing Cargo");
    }
    void releaseLoad(){
        System.out.println("Releasing Load");
    }
}