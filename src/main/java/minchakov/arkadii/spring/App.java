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

            var person = session.get(Person.class, 2);

            session.remove(person);

            for (var item : person.getItems()) {
                System.out.println("До ручной актуализации: " + item);
                item.setPerson(null);
                System.out.println("После: " + item);
                System.out.println();
            }

            session.getTransaction().commit();
        }
    }
}
