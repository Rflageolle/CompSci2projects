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
public class Borders {
    
    static String[] borderGermany = {"Netherlands", "Belgium", "Luxemburg", "Poland", "Czechia", "Austria", "France", "Switzerland"};  
    static String[] borderNetherlands = {"Belgium", "Germany"}; 
    static String[] borderBelgium = {"Netherlands", "Luxemburg", "Germany", "France"}; 
    static String[] borderLuxemburg = {"Belgium", "France", "Germany"};
    static String[] borderPoland = {"Czechia", "Germany"}; 
    static String[] borderCzechia = {"Austria", "Germany", "Poland"}; 
    static String[] borderAustria = {"Switzerland", "Germany", "Czechia"}; 
    static String[] borderFrance = {"Switzerland", "Luxembourg", "Germany", "Belgium"}; 
    static String[] borderSwitzerland = {"France", "Germany", "Austria"};
    
    public static boolean doesBorder(String country1, String country2){
        Boolean doesBorder = false;
        if (country1.equals("Germany")) {
            for (String country : borderGermany) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Netherlands")) {
            for (String country : borderNetherlands) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Belgium")) {
            for (String country : borderBelgium) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Luxemburg")) {
            for (String country : borderLuxemburg) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Poland")) {
            for (String country : borderPoland) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Czechia")) {
            for (String country : borderCzechia) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("Austria")) {
            for (String country : borderAustria) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        if (country1.equals("France")) {
            for (String country : borderFrance) {
                if (country.equals(country2)) {
                    doesBorder = true;
                }
            }
        }
        
        return doesBorder;
    }
    
}
