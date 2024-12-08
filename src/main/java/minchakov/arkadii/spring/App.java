package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Item;
import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person = new Person("Аркадий", 21);

            var item = new Item("Курс по Spring", person);

            person.setItems(new ArrayList<>(List.of(item)));

            session.persist(person);
            session.persist(item);

            session.getTransaction().commit();
        }
    }
}
