package minchakov.arkadii.spring.dao;

import minchakov.arkadii.spring.model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/spring_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "select * from person";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                Person person = new Person(id, name, age, email);
                people.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return people;
    }

    public Person find(int id) {
        return null;
    }

    public void add(Person person) {
        try {
            Statement statement = connection.createStatement();
            String sql = String.format(
                "insert into Person values (%d, '%s', %d, '%s')",
                person.getId(),
                person.getName(),
                person.getAge(),
                person.getEmail()
            );
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Person updatedPerson) {
    }

    public void delete(int id) {
    }
}
