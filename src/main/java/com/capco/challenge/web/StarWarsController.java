package com.capco.challenge.web;

import com.capco.challenge.entity.HumanResponse;
import com.capco.challenge.entity.Person;
import com.capco.challenge.entity.PersonResponse;
import com.capco.challenge.service.StarWarsService;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StarWarsController {

    private static final Logger logger = LoggerFactory.getLogger(StarWarsController.class);

    @Autowired
    StarWarsService starWarsService;

    @ApiModelProperty
    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonResponse> getPeopleById(@PathVariable("id") long id){
        logger.info("Returning the people id: " + id);
        Person person = starWarsService.getPeopleById(id);
        return new ResponseEntity<PersonResponse>(new PersonResponse(person.getName(), person.getBirth_year(), person.getFilms()), HttpStatus.OK);
    }

    @ApiModelProperty
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<Person> getAllPeople(){
        logger.info("Returning all the People´s");

        List<Person> people = starWarsService.getAllPeople();
        Collections.sort(people, Person.getSortByFilmsAndNameComparator());
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @ApiModelProperty
    @RequestMapping(value = "/humans", method = RequestMethod.GET)
    public ResponseEntity<Person> getAllHuman(){
        logger.info("Returning all the People´s");

        List<Person> people = starWarsService.getAllPeople();

        List<Person> humans = people.stream().filter(human ->!human.getGender().equals("n/a")).collect(Collectors.toList());
        Double massTotal = humans.stream().mapToDouble(human -> human.getMass()).sum();
        Double massAverage = massTotal/humans.size();

        HumanResponse response = new HumanResponse();
        response.setMassAverage(massAverage);
        response.setPersonList(humans);
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
