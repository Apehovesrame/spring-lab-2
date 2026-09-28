package ru.kafpin.springlab2.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kafpin.springlab2.model.Serviceman;

public interface ServicemanRepository extends CrudRepository<Serviceman, Long> {
}