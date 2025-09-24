package trucks;

public class ConcreteMixerTruck extends Truck {

    private float drumVolume, chuteLeng;
    private int drumRotationSpeed, waterTankCapacity;
    private String mixerType;

    public ConcreteMixerTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width,
                       int height,
                       float maxLoadCapacity, String fuelType, int horsePower, String transmission, float drumVolume,
                       int drumRotationSpeed, String mixerType, int waterTankCapacity, float chuteLeng) {
        super(numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType,
                horsePower,
                transmission);

        this.drumVolume = drumVolume;
        this.drumRotationSpeed = drumRotationSpeed;
        this.mixerType = mixerType;
        this.waterTankCapacity = waterTankCapacity;
        this.chuteLeng = chuteLeng;

    }

    public void startMixing() {
        System.out.println("Start Mixing");
    }

    public void stopMixing() {
        System.out.println("Stop Mixing");
    }

    void pourConcrete() {
        System.out.println("Pouring Concrete");
    }

    void cleanDrum() {
        System.out.println("Cleaning Drum");
    }

    public void dischargeConcrete() {
        System.out.println("Discharging Concrete");
    }

    void addWater() {
        System.out.println("Adding Water");
    }

}