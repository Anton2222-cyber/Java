package edu.itstep.mvc.model;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class User {
    @Size(min = 2, max = 20, message = "first name no correct...")
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё]+", message = "only letters!")
    private String firstName;
    @NotBlank(message="this field must be not empty")
    private String lastName;
    @Min(16)
    @Max(150)
    private int age;

    private String city;
    private String gender;
    private String[] selectedLanguages;

    private Map<String, String> cities = new LinkedHashMap<>();
    private Map<String, String> genders = new TreeMap<>();
    private Map<String, String> languages = new TreeMap<>();

    {
//        cities.put("Dnepr", "Dn");
//        cities.put("Mariupol", "Mr");
//        cities.put("Sevastopol", "Sv");
//        cities.put("Denetsk", "Dt");

        cities.put("Dn", "Dnepr");
        cities.put("Dt", "Donetsk");
        cities.put("Mr", "Mariupol");
        cities.put("En", "Energodar");
        cities.put("Sv", "Sevastopol");

        genders.put("male", "male");
        genders.put("female", "female");
        genders.put("other", "other");

        languages.put("English", "en");
        languages.put("Ukrainian", "ua");
        languages.put("Deutsch", "de");
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public User() {
    }

    public String getGender() {
        return gender;
    }

    public String[] getSelectedLanguages() {
        return selectedLanguages;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public void setSelectedLanguages(String[] selectedLanguages) {
        this.selectedLanguages = selectedLanguages;
    }

    public Map<String, String> getGenders() {
        return genders;
    }

    public void setGenders(Map<String, String> genders) {
        this.genders = genders;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
