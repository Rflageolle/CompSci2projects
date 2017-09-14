package classprojects;

/**
 *
 * @author ryanflage
 */

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Scanner;


public class HW2 {
    
    CountriesLinkedList countriesLL = new CountriesLinkedList();
    Countries[] countriesArray;
    public static Scanner in = new Scanner(System.in);
    String[] knownCountries = {"Germany", "Netherlands", "Belgium", "Luxemburg", "Poland", "Czechia", "Austria", "France", "Switzerland"};
    
    HW2(String fileName) {
        int counter = 0;
        this.countriesArray = populateArray(fileName);
        for (Countries country : countriesArray) {
            this.countriesLL.addCountry(country);
        }     
    }
    
    
    public static Countries[] populateArray(String fileName) {
	//ArrayList<Countries> fromFile = new ArrayList<>();
        Countries[] fromFile = new Countries[9];
        
        int currentCountry = 0;
	try{
            File text = new File(fileName);
            Scanner inFile = new Scanner(text);//.useDelimiter(",\n\n");
            while(inFile.hasNextLine()){
                String full = inFile.nextLine();       
                //System.out.println(full);
		// countryName (string), latitude String, longitude String, countryArea int
		// countryPopulation int, countryGDP double, countryYear int
                Scanner breaks = new Scanner(full).useDelimiter(", ");
		String[] country = new String[7];
		int currentString = 0;
                while(breaks.hasNext()) {
                    country[currentString] = breaks.next();
                    //System.out.println(country[currentString]);
                    currentString ++;	
                }
                breaks.close();
//                System.out.println(country[0]);
//                System.out.println(country[1]);
//                System.out.println(country[2]);
//                System.out.println(country[3]);
//                System.out.println(country[4]);
//                System.out.println(country[5]);
//                System.out.println(country[6]);
		Countries x = new Countries(country[0], country[1], country[2], Integer.parseInt(country[3]), 
                        Integer.parseInt(country[4]), Double.parseDouble(country[5]), Integer.parseInt(country[6]));
		//fromFile.add(x);
                //System.out.println(x);
                
                fromFile[currentCountry] = x;
                currentCountry++; //this is the one line of code that made me crazy for several hours
            }
           
        } catch( FileNotFoundException e) {
            System.out.print(e.getMessage());
        }    
    return fromFile;
        
    }
      
    public class CountriesLinkedList{
        
        private Node head;
        private int index = 0;
        
        public class Node{
            
            private Countries data;
            private Node next;
            
            public Node(Countries data){
                this.data = data;
                this.next = null;
                // no need to increase index because we want the head to be 0
            }
 
            public Node getNext() {
		return next;
            }
            
            public void setNext(Node nextValue) {
		next = nextValue;
            }
            
            public String getName(){
                return data.countryName;
            }
            
            public int getPopulation(){
                return data.countryPopulation;
            }

        }
        
        public CountriesLinkedList(){
            
        }
        
        public void addCountry(Countries data){
            
            if (head == null) {
                head = new Node(data);
            }
            
            Node added = new Node(data);
            Node current = head;
         
            if (current != null){
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(added);
            }
            index++;
        }
        
        public int getSize(){
            return index + 1;
        }
        
//        public String returnCountryName(String data){
//            Node current = head;
//            String str = "";
//            
//            if (current != null){
//                
//                if (current.getName().equals(data)){
//                    return current.getName();
//                }
//                else {
//                    while (current.next != null){
//                        if (current.getName().equals(data)){
//                            return current.getName();
//                        }
//                    }
//                }
//                    
//            }
//            return str;
//        }
//        
//        public int returnCountryPopulation(int data) {
//            int rtn = 0;
//            while (current.next != null) {
//                if (current.getPopulation() == data){
//                    rtn = current.getPopulation();
//                }
//                else {current = current.next;}
//            }
//            return rtn;
//        }
    }
    
    public static void displayBorderCountries(String name){
        String[] borders = null;
        String str = "Countries that border " + name + ": \n";
        
        switch (name) {
            case "Germany":
                borders = Borders.borderGermany;
                break;
            case "Netherlands":
                borders = Borders.borderNetherlands;
                break;
            case "Belgium":
                borders = Borders.borderBelgium;
                break;
            case "Luxemburg":
                borders = Borders.borderLuxemburg;
                break;
            case "Poland":
                borders = Borders.borderPoland;
                break;
            case "Czechia":
                borders = Borders.borderCzechia;
                break;
            case "Austria":
                borders = Borders.borderAustria;
                break;
            case "France":
                borders = Borders.borderFrance;
                break;
            case "Switzerland":
                borders = Borders.borderSwitzerland;
                break;
            default:
                System.out.println("Sorry the country you are looking "
                        + "for is not an acceptable country");
                break;     
        }
        
        if (borders == null) {
            System.out.print("Better Luck next time");
        }
        else {
            
            for (String item : borders) {
                str += (" -" + item + "\n") ;
            }
            System.out.println(str);
        }
        
    }
    
    public void userOption(){
        boolean cont = false;
        
        System.out.print("This program allows you to choose one of 4 operations: \n"
                        + "1 - Display the countries that border another Country. \n"
                        + "2 - Display all countries that have a population greater "
                        + "than a given population. \n"
                        + "3 - Display the countries that border another Country "
                        + "with a population greater than a given population. \n"
                        + "4 - Quit the program. \n\n"
                        + "To select the program simply type the number corresponding to "
                        + "the operation you want to be completed and then follow the instructions \n"
                        + "on screen. (When entering Countries use upper-case first letter followed by lower-case form) \n"
                        + "------------------------------------------------------------------------------------------------- \n\n");
        
        do{
            System.out.print("Which Operation would you like to perform: ");
            int operation = in.nextInt();
            boolean moveOn = false;
            
            switch (operation) {
                case 1:
                    String country = "";
                    
                    while (!moveOn){
                        System.out.println("Which country: ");
                        country = in.next();
                        moveOn = validCountry(this.knownCountries, country);
                    }
                    
                    displayBorderCountries(country);
                    cont = doContinue();
                    break;
                case 2:
                    int pop = 0;
                    
                    do {
                        System.out.println("What population would you like to test? (whole number): ");
                        moveOn = in.hasNextInt();   
                    } while (!moveOn);
                    pop = Integer.parseInt(in.next());
                    aboveMinimumPopulation(this.countriesArray, pop);
                    cont = doContinue();
                    break;
                case 3:
                    int pop2 = 0;
                    String country2 = "";
                    do {
                        System.out.println("What Country's borders would you like to check?");
                        country2 = in.next();
                        moveOn = validCountry(this.knownCountries, country2);
                    } while (!moveOn);
                    
                    do {
                        System.out.println("What population? (whole number): ");
                        moveOn = in.hasNextInt();
                    } while (!moveOn);
                    pop2 = in.nextInt();
                    greaterPopulationAndBorder(this.countriesArray, pop2, country2);
                    cont = doContinue();
                    break;
                    
                case 4:
                    cont = false;        
            }
            
        } while (cont);
    }
    
    public static void aboveMinimumPopulation(Countries[] data, int min){
        String str = "Countries with Population over " + min + ":\n";
        String chstr = "";
        
        for (Countries data1 : data) {
            int check = data1.countryPopulation;
            
            if (check > min){
                chstr += " -" + data1.countryName + "\n";
            }
        }
        System.out.println(str + chstr);
    }
    
    public static Boolean validCountry(String[] knownCountries, String countryStr){
        Boolean valid = false;
        for (String country : knownCountries) {
            if (country.equals(countryStr)) {
                valid = true;
            }
        }
        return valid;
    }
    
    public static void greaterPopulationAndBorder(Countries[] data, int min, String name){
        String[] borders = null;
        String fin = "Countries that border " + name + " and have a population greater than " + min + ": \n";
        
        switch (name) {
            case "Germany":
                borders = Borders.borderGermany;
                break;
            case "Netherlands":
                borders = Borders.borderNetherlands;
                break;
            case "Belgium":
                borders = Borders.borderBelgium;
                break;
            case "Luxemburg":
                borders = Borders.borderLuxemburg;
                break;
            case "Poland":
                borders = Borders.borderPoland;
                break;
            case "Czechia":
                borders = Borders.borderCzechia;
                break;
            case "Austria":
                borders = Borders.borderAustria;
                break;
            case "France":
                borders = Borders.borderFrance;
                break;
            case "Switzerland":
                borders = Borders.borderSwitzerland;
                break;
            default:
                System.out.println("Sorry the country you are looking "
                        + "for is not an acceptable country");
                break;     
        }
        
        for (Countries thing : data) {
            if (thing.countryPopulation > min) {
                for (String str : borders) {
                    if (thing.countryName.equals(str)) {
                        fin += " -" + thing.countryName + "\n";
                    }
                }
            }
        }
        
        System.out.println(fin);
    }
    
    public static Boolean doContinue(){
        Boolean b = true;
        Boolean rtn = false;
        do {
            System.out.print("\n" + "Would you like to Continue? (Y or N): ");
            switch (in.next()) {
                case "Y":
                case "y":
                    rtn = true;
                    break;
                case "N":
                case "n":
                    rtn = false;
                    break;
                default:
                    b = false;
                    break;
            }
        } while (!b);
        return rtn;        
    }
    
    public static void main(String[] args) {
        HW2 current = new HW2("/Users/FlageMac/School/Fall2017/ComputerScience2/Project2/countries_data.txt");
        current.userOption();
    }
    
    

}
