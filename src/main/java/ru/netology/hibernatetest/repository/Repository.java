package ru.netology.hibernatetest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager manager;

    public List getPersonsByCity(String city) {
        return manager.createQuery("select p from Person p where p.city_of_living = :city")
                .setParameter("city", city).getResultList();
    }
}
