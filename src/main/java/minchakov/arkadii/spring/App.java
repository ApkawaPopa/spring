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

            var person = new Person("Елизавета", 21);

            person.addItem(new Item("Палетка"));
            person.addItem(new Item("Помада"));
            person.addItem(new Item("Гель-лак для ногтей"));

            session.persist(person);

            session.getTransaction().commit();
        }
    }
}
