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
            // не нужно переделывать на PreparedStatement, т.к. не используем в запросе данные от пользователя
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
        Person person = null;

        try {
            PreparedStatement statement = connection.prepareStatement("select * from person where id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                person = new Person(id, name, age, email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return person;
    }

    public void add(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into person values (10, ?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Person updatedPerson) {
        try {
            PreparedStatement statement = connection.prepareStatement("update person set name=?, age=?, email=? where id=?");
            statement.setString(1, updatedPerson.getName());
            statement.setInt(2, updatedPerson.getAge());
            statement.setString(3, updatedPerson.getEmail());
            statement.setInt(4, updatedPerson.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("delete from person where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
