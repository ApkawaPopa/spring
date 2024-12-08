package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Item;
import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person = session.get(Person.class, 1);

            System.out.println("До добавления новой вещи: " + person);

            var item = new Item("Bomb", person);

            session.persist(item);

            System.out.println("После добавления новой вещи: " + person);

            person.getItems().add(item);

            System.out.println("После ручного обновления items: " + person);

            session.getTransaction().commit();
        }
    }
}
