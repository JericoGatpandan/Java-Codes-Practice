package trucks;

public class FireTruck extends Truck{

    private int waterTankCapacity, pumpPower, ladderLength;
    private boolean hasEmergencyLights, hasSiren;

    public FireTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height,
              float maxLoadCapacity, String fuelType, int horsePower, String transmission, int waterTankCapacity, int pumpPower, int ladderLength, boolean hasEmergencyLights, boolean hasSiren) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower,
                transmission);
        //TODO Auto-generated constructor stub
        this.waterTankCapacity = waterTankCapacity;
        this.pumpPower = pumpPower;
        this.ladderLength = ladderLength;
        this.hasEmergencyLights = hasEmergencyLights;
        this.hasSiren = hasSiren;

    }


    public void sprayWater() {
        System.out.println("Spraying Water");
    }
    public void extendLadder() {
        System.out.println("Extending Ladder");
    }
    public void activateSiren(boolean on) {
        if(on) {
            System.out.println("Siren On");
        } else {
            System.out.println("Siren Off");
        }
    }
    public void turnOnEmergencyLights(boolean on) {
        if(on) {
            System.out.println("Emergency Lights On");
        } else {
            System.out.println("Emergency Lights Off");
        }
    }


}