package trucks;
import main.Vehicle;
import components.Owner;
import components.Engine;

public class Truck extends Vehicle{
    private float maxLoadCapacity;
    private String fuelType;
    private int horsePower;
    private String transmission;
    
    // HAS-A relationships (Composition)
    private Owner owner;
    private Engine engine;

    Truck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height, float maxLoadCapacity, String fuelType, int horsePower, String transmission) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height);
        this.maxLoadCapacity = maxLoadCapacity;
        this.fuelType = fuelType;
        this.horsePower = horsePower;
        this.transmission = transmission;
        
        // Initialize HAS-A components
        this.engine = new Engine("Diesel Engine", horsePower, fuelType);
        this.owner = null; // No owner initially
    }

    public void Load() {
        System.out.println("Loading");
    }
    public void unLoad() {
        System.out.println("Unloading");
    }
    public void secureLoad() {
        System.out.println("Securing Load ");
    }
    public void removeLoad() {
        System.out.println("Removing Load");
    }
    
    // Methods to manage HAS-A relationships
    public void assignOwner(Owner owner) {
        this.owner = owner;
        System.out.println("Owner assigned: " + owner.getName() + " from " + owner.getCompany());
    }
    
    public void startEngine() {
        engine.start();
    }
    
    public void stopEngine() {
        engine.stop();
    }
    
    public void accelerateEngine() {
        engine.accelerate();
    }
    
    public void decelerateEngine() {
        engine.decelerate();
    }
    
    public void reportMaintenance() {
        if (owner != null) {
            owner.reportMaintenance();
        } else {
            System.out.println("No owner assigned to report maintenance");
        }
    }
    
    // Getters for HAS-A components
    public Owner getOwner() { return owner; }
    public Engine getEngine() { return engine; }

}
