import java.util.*;

public class LambdaSort {

    public static void main(String[] args) {

        List<String> names =
            new ArrayList<>();

        names.add("Ravi");
        names.add("Ankit");
        names.add("Zoya");
        names.add("Aman");

        Collections.sort(
            names,
            (a, b) -> a.compareTo(b)
        );

        System.out.println(names);
    }
}