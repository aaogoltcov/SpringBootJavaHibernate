package netology.springbootjavahibernate.persons.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.OrderBy;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer>, JpaSpecificationExecutor<PersonEntity> {

    @Query("""
            select distinct p
            from PersonEntity p
            where p.cityOfLiving = :city
            """)
    Collection<PersonEntity> getPersonsByCity(String city);

    @OrderBy("age ASC")
    Collection<PersonEntity> getPersonsByAgeLessThan(Integer age);

    PersonEntity getFirstPersonByNameAndSurnameAndAge(String name, String surname, Integer age);

    Optional<PersonEntity> getFirstPersonByNameAndSurname(String name, String surname);
}
