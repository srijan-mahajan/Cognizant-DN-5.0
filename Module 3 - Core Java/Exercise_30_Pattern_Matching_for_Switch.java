public class PatternMatchingDemo {

    static void checkType(Object obj) {

        switch(obj) {

            case Integer i ->
                System.out.println(
                    "Integer: " + i
                );

            case String s ->
                System.out.println(
                    "String: " + s
                );

            case Double d ->
                System.out.println(
                    "Double: " + d
                );

            case null ->
                System.out.println(
                    "Null Value"
                );

            default ->
                System.out.println(
                    "Unknown Type"
                );
        }
    }

    public static void main(String[] args) {

        checkType(10);

        checkType("Hello");

        checkType(3.14);
    }
}