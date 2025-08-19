import java.util.HashSet;

public class HashSetImplement {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();

        colors.add("red");
        colors.add("blue");
        colors.add("red");

        System.out.println(colors);

    }
}
