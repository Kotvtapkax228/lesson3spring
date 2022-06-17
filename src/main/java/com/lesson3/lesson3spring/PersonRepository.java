package com.lesson3.lesson3spring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findBySurname(String surname);
    @Query("select * from people where name = :fname")
    List<Person> findByName(@Param("fname") String name);
}
