package ru.netology.hibernatetest.service;

import ru.netology.hibernatetest.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List getPersonByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
