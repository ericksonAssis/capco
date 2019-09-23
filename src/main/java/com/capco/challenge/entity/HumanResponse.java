package com.capco.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HumanResponse {

    private List<Person> personList;
    private Double massAverage;

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setMassAverage(Double massAverage) {
        this.massAverage = massAverage;
    }

    public Double getMassAverage() {
        return massAverage;
    }
}
