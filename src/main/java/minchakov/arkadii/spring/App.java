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

            var item = session.get(Item.class, 1);

            var oldPerson = item.getPerson();

            var newPerson = session.get(Person.class, 4);

            item.setPerson(newPerson);

            System.out.println("Вещи прошлого человека после удаления вещи с id = 1: " + oldPerson.getItems());
            System.out.println("Вещи нового человека после добавления вещи с id = 1: " + newPerson.getItems());

            oldPerson.getItems().remove(item);
            newPerson.getItems().add(item);

            System.out.println("Вещи прошлого человека после актуализации: " + oldPerson.getItems());
            System.out.println("Вещи нового человека после актуализации: " + newPerson.getItems());

            session.getTransaction().commit();
        }
    }
}
