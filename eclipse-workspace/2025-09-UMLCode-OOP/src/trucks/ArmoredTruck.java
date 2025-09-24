package trucks;

public class ArmoredTruck extends Truck{

    private String armorLevel;
    private float bulletProofGlassThickness;
    private float secureCompartmentVolume;
    private String alarmSystemType;
    private boolean hasReinforcedTires;

    public ArmoredTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height, 
                float maxLoadCapacity, String fuelType, int horsePower, String transmission, boolean hasArmor, boolean hasAlarm, 
                boolean hasReinforcedTires, String armorType){
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower, transmission);

        this.armorLevel = armorType;
        this.hasReinforcedTires = hasReinforcedTires;
    }


    public void lockDoors(){
        System.out.println("Locking Doors");
    }

    void lockSecureCompartment(){
        System.out.println("Locking Secure Compartment...");
        System.out.println("Secure Compartment Locked.");
    }

    void unlockSecureCompartment(){
        System.out.println("Unlocking Secure Compartment...");
        System.out.println("Secure Compartment Unlocked.");
    }

    public void activateAlarm(){
        System.out.println("Alarm Activated.");
    }

    void deactivateAlarm(){
        System.out.println("Alarm Deactivated.");
    }
}