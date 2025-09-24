import java.util.*;

// NenUser class represents a person with Nen abilities
public class NenUser {
    private static Random random = new Random();

    private String userName;
    private NenType nenType;
    private ArrayList<String> subTypes = new ArrayList<>();

    private final String determination = "determination";
    private final String creativity = "creativity";
    private final String impulsiveness = "impulsiveness";
    private final String intelligence = "intelligence";
    private final String manipulation = "manipulation";
    private final String uniqueness = "uniqueness";

    HashMap<String, Integer> characterAttributes = new HashMap<>();

    // Constructor
    public NenUser(String userName) {
        this.userName = userName;

        characterAttributes.put(this.determination, random.nextInt(10));
        characterAttributes.put(this.creativity, random.nextInt(10));
        characterAttributes.put(this.impulsiveness, random.nextInt(10));
        characterAttributes.put(this.intelligence, random.nextInt(10));
        characterAttributes.put(this.manipulation, random.nextInt(10));
        characterAttributes.put(this.uniqueness, random.nextInt(10));
    }

    // methods to set and get the NenType
    public NenType getNenType() {
        return nenType;
    }

    public String getUserName() {
        return this.userName;
    }

    /*
     * public void setNenType(NenType newNenType) {
     * this.nenType = newNenType;
     * }
     * 
     * public HashMap<String, Integer> getAttribute() {
     * return characterAttributes;
     * }
     */

    public void showStats() {
        System.out.println("Determination (Enhancer): " + characterAttributes.get(determination));
        System.out.println("Creativity (Emitter): " + characterAttributes.get(creativity));
        System.out.println("Impulsiveness (Transmuter): " + characterAttributes.get(impulsiveness));
        System.out.println("Intelligence (Conjurer): " + characterAttributes.get(intelligence));
        System.out.println("Manipulation (Manipulator): " + characterAttributes.get(manipulation));
        System.out.println("Uniqueness (Specialist): " + characterAttributes.get(uniqueness));

        if (nenType != null) {
            System.out.println(userName + " -> Nen Type: " + nenType.getName());
        } else {
            System.out.println("Nen Type: Not determined yet");
        }
    }

    // A tie-breaking mechanism for when two attributes have the same value.
    private String getHighestAttribute() {
        List<String> priorityOrder = Arrays.asList(determination, creativity, impulsiveness, intelligence, manipulation,
                uniqueness);

        int maxValue = Collections.max(characterAttributes.values());
        for (String attribute : priorityOrder) {
            if (characterAttributes.get(attribute) == maxValue) {
                return attribute;
            }
        }
        return determination;
    }

    public void waterDivination() {
        System.out.println(userName + " performs the water divination test...");
        // NenType objects for each category
        NenType enhancer = new NenType("Enhancer", "The water volume changes");
        NenType emitter = new NenType("Emitter", "The water color changes");
        NenType transmuter = new NenType("Transmuter", "The water taste changes");
        NenType conjurer = new NenType("Conjurer", "Impurities appear in water");
        NenType manipulator = new NenType("Manipulator", "Leaf moves on the water");
        NenType specialist = new NenType("Specialist", "Different change appears");

        String highestAttribute = getHighestAttribute();

        if (highestAttribute.equals(determination)) {
            this.nenType = enhancer;
            System.out.println("The water's volume changed! " + userName + " is an Enhancer!");
        } else if (highestAttribute.equals(creativity)) {
            this.nenType = emitter;
            System.out.println("The water's color changed! " + userName + " is an Emitter!");
        } else if (highestAttribute.equals(impulsiveness)) {
            this.nenType = transmuter;
            System.out.println("The water's taste changed! " + userName + " is a Transmuter!");
        } else if (highestAttribute.equals(intelligence)) {
            this.nenType = conjurer;
            System.out.println("Impurities appeared in the water! " + userName + " is a conjurer!");
        } else if (highestAttribute.equals(manipulation)) {
            this.nenType = manipulator;
            System.out.println("The leaf moved! " + userName + " is a manipulator!");
        } else {
            this.nenType = specialist;
            System.out.println("Something unique happened to the water! " + userName + " is a specialist!");
        }
        System.out.println("Water effect: " + nenType.getWaterEffect());
    }

    public void assignSubTypes() {
        subTypes.clear();
        if (nenType == null) {
            System.out.println("Cannot assign sub-types before determining main Nen type.");
            return;
        }

        System.out.println("\nDetermining sub-types for " + userName + "...");
        String mainType = nenType.getName();
        int chance = random.nextInt(101); // 0-100

        System.out.println(userName + "'s main type: " + mainType);
        System.out.print("Sub-types: ");

        // Enhancer sub-types
        if (mainType.equals("Enhancer")) {
            // Stores sub-types in an ArrayList instead of just printing them
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Transmuter", "Emitter"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Conjurer", "Manipulator"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Specialist");
        } else if (mainType.equals("Transmuter")) {
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Enhancer", "Conjurer"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Specialist", "Emitter"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Manipulator");
        } else if (mainType.equals("Emitter")) {
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Enhancer", "Manipulator"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Transmuter", "Specialist"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Conjurer");
        } else if (mainType.equals("Conjurer")) {
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Transmuter", "Specialist"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Enhancer", "Manipulator"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Emitter");
        } else if (mainType.equals("Manipulator")) {
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Specialist", "Emitter"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Conjurer", "Enhancer"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Transmuter");
        } else if (mainType.equals("Specialist")) {
            if (chance >= 41 && chance <= 80)
                subTypes.addAll(Arrays.asList("Manipulator", "Conjurer"));
            if (chance >= 11 && chance <= 40)
                subTypes.addAll(Arrays.asList("Transmuter", "Emitter"));
            if (chance >= 1 && chance <= 10)
                subTypes.add("Enhancer");
        }
        if (subTypes.isEmpty()) {
            System.out.print("None" + "\n");
        } else {
            System.out.println(String.join(" and ", subTypes)); 
        }
    }
}