package com.capco.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class Person {

    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String[] films;
    private String[] species;
    private String[] vehicles;
    private String[] starships;
    private String created;
    private String edited;
    private String url;

    public static class SortByFilmsAndName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {

            int filmsCompare = 0;
            int nameCompare = 0;

            if (o1.films.length > o2.films.length){
                filmsCompare = -1;
            }else if(o1.films.length < o2.films.length){
                filmsCompare = 1;
            }else{
                filmsCompare = 0;
            }

            nameCompare = o1.name.compareTo(o2.name);

            if (filmsCompare == 0) {
                return ((nameCompare == 0) ? filmsCompare : nameCompare);
            } else {
                return filmsCompare;
            }
        }
    }

    public static SortByFilmsAndName getSortByFilmsAndNameComparator(){
        return new SortByFilmsAndName();
    }

    public void setFilms(String[] films) {
        this.films = films;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String[] getFilms() {
        return films;
    }

    public String getName() {
        return name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public Integer getMass() {
        return mass;
    }

    public String getGender() {
        return gender;
    }
}
