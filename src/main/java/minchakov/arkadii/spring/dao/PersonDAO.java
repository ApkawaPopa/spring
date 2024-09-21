package minchakov.arkadii.spring.dao;

import minchakov.arkadii.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Person find(int id) {
        return jdbcTemplate.query("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class), id)
            .stream().findAny().orElse(null);
    }

    public void add(Person person) {
        jdbcTemplate.update(
            "insert into person values (10, ?, ?, ?)",
            person.getName(),
            person.getAge(),
            person.getEmail()
        );
    }

    public void update(Person person) {
        jdbcTemplate.update(
            "update person set name=?, age=?, email=? where id=?",
            person.getName(),
            person.getAge(),
            person.getEmail(),
            person.getId()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
