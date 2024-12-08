package minchakov.arkadii.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Item() {
    }

    public Item(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", person=" + (person != null ? "'" + person.getName() + "'" : "null") +
            '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
