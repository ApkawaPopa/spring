package minchakov.arkadii.spring;

import minchakov.arkadii.spring.model.Item;
import minchakov.arkadii.spring.model.Person;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (var sessionFactory = configuration.buildSessionFactory()) {
            var session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            var person = session.get(Person.class, 3);
            System.out.println(person);

            var items = person.getItems();

            System.out.println("Акутальные вещи, сразу после запроса: " + items);

            var item1 = items.getFirst();
            if (item1 != null) {
                session.remove(item1);
            }

            System.out.println("Вещи после удаления первой из списка, внутри транзакции: " + person.getItems());

            var item2 = items.get(1);
            if (item2 != null) {
                session.remove(item2);
            }

            session.getTransaction().commit();

            System.out.println("Вещи после удаления первых двух из списка, снаружи транзакции: " + person.getItems());

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            MutationQuery query = session.createMutationQuery("update Item set id = :oldId where id = :newId");

            if (item1 != null) {
                var oldId = item1.getId();
                var newId = session.merge(item1).getId();
                query.setParameter("oldId", oldId);
                query.setParameter("newId", newId);
                query.executeUpdate();
            }

            if (item2 != null) {
                var oldId = item2.getId();
                var newId = session.merge(item2).getId();
                query.setParameter("oldId", oldId);
                query.setParameter("newId", newId);
                query.executeUpdate();
            }

            session.getTransaction().commit();
        }
    }
}
