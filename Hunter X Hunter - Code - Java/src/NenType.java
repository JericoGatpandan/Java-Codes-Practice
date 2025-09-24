// NenType class represents different Nen categories
public class NenType {
    private String name;
    private String waterEffect;

    // Constructor
    public NenType(String name, String waterEffect) {
        this.name = name;
        this.waterEffect = waterEffect;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getWaterEffect() {
        return waterEffect;
    }

    /* 
    // A toString() method that displays Nen type information
    public String toString() {
        return name + ": " + waterEffect;
    } */
}