package trucks;

public class FlatbedTruck extends Truck {
    // - bedLength: float
    // - bedWidth: float
    // - maxLoadWeight: int
    // - hasSideRails: bool
    // - bedMaterial: String
    private float bedLength, bedWidth;
    private int maxLoadWeight;
    private boolean hasSideRails;
    private String bedMaterial;

    public FlatbedTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width,
                 int height, float maxLoadCapacity, String fuelType, int horsePower, String transmission, float bedLength,
                 float bedWidth, int maxLoadWeight, boolean hasSideRails, String bedMaterial) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType,
                horsePower, transmission);
        this.bedLength = bedLength;
        this.bedWidth = bedWidth;
        this.maxLoadWeight = maxLoadWeight;
        this.hasSideRails = hasSideRails;
        this.bedMaterial = bedMaterial;

    }

    public void lowerBed() {
        System.out.println("Lowering Bed");
    }

    public void raiseBed() {
        System.out.println("Raising Bed");
    }

    public void secureCargo() {
        System.out.println("Securing Cargo");
    }

    public void releaseCargo() {
        System.out.println("Releasing Cargo");
    }

    //
    // + checkBedIntegrity()
    // + deploySideRails()
    // + retractSideRails()
    void checkBedIntegrity() {
        System.out.println("Checking Bed Integrity");
    }

    void deploySideRails() {
        if (hasSideRails) {
            System.out.println("Deploying Side Rails");
        } else {
            System.out.println("No Side Rails to Deploy");
        }
    }

    void retractSideRails() {
        if (hasSideRails) {
            System.out.println("Retracting Side Rails");
        } else {
            System.out.println("No Side Rails to Retract");
        }
    }

}