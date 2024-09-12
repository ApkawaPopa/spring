package minchakov.arkadii.spring.dao;

import minchakov.arkadii.spring.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private int id = 0;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        String[] names = new String[]{"Tom", "Jack", "Michael", "Lenny", "Sophia"};

        for (int i = 0; i < 5; i++) {
            people.add(new Person(++id, names[i]));
        }
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++id);
        people.add(person);
    }
}
