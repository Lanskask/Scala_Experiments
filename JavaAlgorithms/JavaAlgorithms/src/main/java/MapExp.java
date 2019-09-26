import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapExp {
    Person p1 = new Person("andy",10);
    Person p2 = new Person("andy", 10);


    Map<Long, Person> map = new HashMap<>();

    void run() {
        map.put(1L,p1);
        map.put(2L,p2);

        arr.size();

        Date date = new Date();

        System.currentTimeMillis();
    }

    public static void main(String[] args) {
        MapExp mapExp = new MapExp();
        mapExp.run();
    }

    ArrayList<Integer> arr =
             new ArrayList<>();
}

class Person {
    private int age;
    private String name;

    public Person (String name, int age) {
        this.age = age;
        this.name = name;
    }
}
