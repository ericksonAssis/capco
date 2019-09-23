package com.capco.challenge.service;

import com.capco.challenge.entity.Person;

import java.util.List;

public interface StarWarsService {

    List<Person> getAllPeople();
    Person getPeopleById(long id);
    List getAllUsers();
}
