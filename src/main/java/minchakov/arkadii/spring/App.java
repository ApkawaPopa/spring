package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var people = session.createQuery("from Person where age >= 30", Person.class).getResultList();
            for (Person person : people) {
                System.out.println(person.getName());
            }

            session.createMutationQuery("delete from Person where name like '%name%'").executeUpdate();

            session.getTransaction().commit();
        }
    }
}
