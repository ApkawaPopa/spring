package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person1 = session.get(Person.class, 1);
            person1.setName("Updated name");

            var person2 = session.get(Person.class, 2);
            if (person2 != null) {
                session.remove(person2);
            }

            var newPerson = new Person("New Person", 40);
            System.out.println("newPerson.id: " + newPerson.getId());
            session.persist(newPerson);
            System.out.println("newPerson.id: " + newPerson.getId());

            session.getTransaction().commit();
        }
    }
}
