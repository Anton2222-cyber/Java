package edu.itstep.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "population")
    private long population;
    @Column(name = "language")
    private String language;
    @Column(name = "area")
    private double area;
    @Column(name = "government_form")
    private String governmentForm;

    public Country(String countryName, long population, String language, double area, String governmentForm) {
        this.countryName = countryName;
        this.population = population;
        this.language = language;
        this.area = area;
        this.governmentForm = governmentForm;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    @Override
    public String toString() {
        return countryName + " " + population + " осіб";
    }
}
