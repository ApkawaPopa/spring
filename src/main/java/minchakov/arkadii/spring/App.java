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

            var person = session.get(Person.class, 3);

            for (var item : person.getItems()) {
                session.remove(item);
            }

            System.out.println("Поле с вещами человека после удаления их всех: " + person.getItems());

            person.getItems().clear();

            System.out.println("После ручной очистки: " + person.getItems());

            session.getTransaction().commit();
        }
    }
}
