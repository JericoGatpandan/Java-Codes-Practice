package trucks;

public class TrailerTruck extends Truck{
    private int numberOfTrailers;

    public TrailerTruck(int numberOfWheels, int steering, int chair, int mirror, int maxSpeed, int length, int width, int height,
                 float maxLoadCapacity, String fuelType, int horsePower, String transmission, int numberOfTrailers) {
        super (numberOfWheels, steering, chair, mirror, maxSpeed, length, width, height, maxLoadCapacity, fuelType, horsePower, transmission);
        this.numberOfTrailers = numberOfTrailers;
    }

    public void attachTrailer (){
        System.out.println("Attaching...");
    }
    public void detachTrailer (){
        System.out.println("Detaching...");
    }


}