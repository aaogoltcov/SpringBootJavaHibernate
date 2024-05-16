package netology.springbootjavahibernate.persons.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    public Collection<PersonEntity> getPersonsByCity(String city) {
        return entityManager
                .createQuery("from PersonEntity p where p.cityOfLiving = :city", PersonEntity.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<PersonEntity> findAll() {
        return entityManager
                .createQuery("from PersonEntity p", PersonEntity.class)
                .getResultList()
                .stream()
                .toList();
    }
}
