package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person1 = new Person("name1", 10);
            var person2 = new Person("name2", 20);
            var person3 = new Person("name3", 30);

            session.persist(person1);
            session.persist(person2);
            session.persist(person3);

            session.getTransaction().commit();
        }
    }
}
