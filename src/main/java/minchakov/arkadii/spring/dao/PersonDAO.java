package minchakov.arkadii.spring.dao;

import minchakov.arkadii.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> find(int id) {
        return jdbcTemplate.query("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class), id)
            .stream().findAny();
    }

    public Optional<Person> find(String email) {
        return jdbcTemplate.query("select * from person where email=?", new BeanPropertyRowMapper<>(Person.class), email)
            .stream().findAny();
    }

    public void add(Person person) {
        jdbcTemplate.update(
            "insert into person(name, age, email, address) values (?, ?, ?, ?)",
            person.getName(),
            person.getAge(),
            person.getEmail(),
            person.getAddress()
        );
    }

    public void update(Person person) {
        jdbcTemplate.update(
            "update person set name=?, age=?, email=?, address=? where id=?",
            person.getName(),
            person.getAge(),
            person.getEmail(),
            person.getAddress(),
            person.getId()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }

    public void batchInsert(List<Person> people) {
        jdbcTemplate.batchUpdate(
            "insert into person values(?, ?, ?, ?, ?)",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement statement, int i) throws SQLException {
                    Person person = people.get(i);
                    statement.setInt(1, person.getId());
                    statement.setString(2, person.getName());
                    statement.setInt(3, person.getAge());
                    statement.setString(4, person.getEmail());
                    statement.setString(5, person.getAddress());
                }

                @Override
                public int getBatchSize() {
                    return people.size();
                }
            }
        );
    }

    public void multipleInsert(List<Person> people) {
        for (var person : people) {
            add(person);
        }
    }

    public List<Person> make1000People() {
        Random random = new Random();
        int batchId = random.nextInt(0, Integer.MAX_VALUE);

        List<Person> people = new ArrayList<>();
        String[] countries = {"Russia", "France", "United States"};
        String[][] cities = {
            {"Moscow", "Krasnoyarsk", "Belgorod", "Novosibirsk"},
            {"Paris", "Mougins", "Bougival", "Marsel"},
            {"New York", "Washington", "Brooklyn", "Texas"}
        };
        for (int i = 0; i < 1000; i++) {
            int personAge = random.nextInt(120);
            int country = random.nextInt(countries.length);
            int city = random.nextInt(cities[country].length);
            String postcodePrefix = String.format("%03d", random.nextInt(1000));
            String postcodeSuffix = String.format("%03d", i);
            String suffix = batchId + "_" + i;
            people.add(
                new Person(
                    random.nextInt(0, Integer.MAX_VALUE),
                    "Person " + suffix,
                    personAge,
                    "person" + suffix + "@internet.ru",
                    countries[country] + ", " + cities[country][city] + ", " + postcodePrefix + postcodeSuffix
                )
            );
        }

        return people;
    }
}
