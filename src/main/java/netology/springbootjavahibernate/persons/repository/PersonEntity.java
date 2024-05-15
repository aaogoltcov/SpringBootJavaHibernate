package netology.springbootjavahibernate.persons.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "persons")
@Getter
@Setter
@Entity
@IdClass(PersonId.class)
public class PersonEntity {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private Integer age;
    private String phoneNumber;
    private String cityOfLiving;
}
