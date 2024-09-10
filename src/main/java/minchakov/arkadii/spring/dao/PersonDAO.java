package minchakov.arkadii.spring.dao;

import minchakov.arkadii.spring.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final List<Person> people;

    {
        people = new ArrayList<>();

        String[] names = new String[]{"Tom", "Jack", "Michael", "Lenny", "Sophia"};

        for (int i = 0; i < 5; i++) {
            people.add(new Person(i + 1, names[i]));
        }
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.id() == id).findAny().orElse(null);
    }
}
