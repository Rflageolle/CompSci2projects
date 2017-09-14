/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classprojects;

/**
 *
 * @author ryanflage
 */
public class Countries {
    String countryName; 
    String latitude; 
    String longitude; 
    int countryArea; 
    int countryPopulation;
    double countryGDP;
    int countryYear;
    
    Countries() {
    
    }
    
    Countries(String name, String lat, String longi, int area, int pop, double gdp, int year){
        this.countryName = name;
        this.latitude = lat;
        this.longitude = longi;
        this.countryArea = area;
        this.countryPopulation = pop;
        this.countryGDP = gdp;
        this.countryYear = year;
        
    }
    
    @Override
    public String toString(){
        String str = String.format("name: %s, latitude: %s, longitude: %s, area: %d, population: %d, GDP: %f, year: %d ", this.countryName, this.latitude, this.longitude, this.countryArea, this.countryPopulation, this.countryGDP, this.countryYear);
        return str;
    }
    
    
    
}
