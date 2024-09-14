package minchakov.arkadii.spring.model;

import javax.validation.constraints.*;

public class Person {
    private int id;

    @NotBlank(message = "Name should not be blank")
    @Size(min = 3, max = 50, message = "Name length should be from 3 to 50 characters")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Name should consist only uppercase or lowercase latin letters or spaces")
    private String name;

    @PositiveOrZero(message = "Age should be non-negative")
    private int age;

    @NotBlank(message = "Email should not be blank")
    @Email(message = "This is not a correct email")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
