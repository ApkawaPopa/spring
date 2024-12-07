package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person = session.get(Person.class, 1);

            System.out.printf("Name: %s\nAge: %d\n", person.getName(), person.getAge());

            session.getTransaction().commit();
        }
    }
}
