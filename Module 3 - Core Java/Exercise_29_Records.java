import java.util.List;

record Person(String name, int age) {}

public class RecordDemo {

    public static void main(String[] args) {

        Person p1 = new Person("Trishant", 21);
        Person p2 = new Person("Rahul", 17);
        Person p3 = new Person("Aman", 25);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> persons = List.of(p1, p2, p3);

        persons.stream()
               .filter(person -> person.age() >= 18)
               .forEach(System.out::println);
    }
}