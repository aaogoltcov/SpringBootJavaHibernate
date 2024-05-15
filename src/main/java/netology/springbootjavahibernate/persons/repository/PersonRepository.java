package netology.springbootjavahibernate.persons.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer>, JpaSpecificationExecutor<PersonEntity>  {

    @Query("""
            select distinct p
            from PersonEntity p
            where p.cityOfLiving = :city
            """)
    Collection<PersonEntity> getPersonsByCity(String city);
}
