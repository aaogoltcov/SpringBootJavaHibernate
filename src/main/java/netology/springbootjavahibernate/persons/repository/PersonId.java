package netology.springbootjavahibernate.persons.repository;

import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private Integer age;

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PersonId personId))
            return false;
        return Objects.equals(name, personId.name) && Objects.equals(surname, personId.surname) && Objects.equals(age, personId.age);
    }

    @Override public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
