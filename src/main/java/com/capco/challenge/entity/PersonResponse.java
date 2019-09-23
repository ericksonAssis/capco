package com.capco.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class PersonResponse {

    private String name;
    private String birthDateYear;
    private String[] films;

    public PersonResponse(String name,String birthDateYear, String[] films){
        this.name = name;
        this.birthDateYear = birthDateYear;
        this.films = films;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDateYear(String birthDateYear) {
        this.birthDateYear = birthDateYear;
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getBirthDateYear() {
        return birthDateYear;
    }

    public String[] getFilms() {
        return films;
    }
}
