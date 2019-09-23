package com.capco.challenge.service;

import com.capco.challenge.entity.Person;
import com.capco.challenge.entity.PeopleResponse;
import com.capco.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service("starWarsService")
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${resource}/people")
    private String resourcePeople;

    @Value("${resource}/people/{id}")
    private String resourcePeopleId;

    @Override
    public List<Person> getAllPeople() {
        return restTemplate.getForEntity(resourcePeople, PeopleResponse.class).getBody().getResults();
    }

    @Override
    public Person getPeopleById(long id) {
        return restTemplate.getForEntity(resourcePeopleId, Person.class, id).getBody();
    }

    @Override
    public List getAllUsers() {
        return userRepository.findAll();
    }
}
