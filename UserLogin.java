/*
 * User Input September 2, 2017
 *
 * Ryan Flageolle Computer Science 2 
 *
 * This program evaluates whether a given string: is longer than 5 characters,
 * contains both upper and lower case letters, contains digits, and contains 
 * special characters ( !, @, #, $ )
 */
package classprojects;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author FlageMac
 */
public class UserLogin {
    
    // static scanner used to read in user input
    static Scanner in = new Scanner(System.in);
    
    // static String Buffer to hold all usernames and their validity
    static StringBuffer sb = new StringBuffer("User Report File: \n\n");
    
    // string to hold the user input
    private String username;
//    private Boolean hasCaps = false;
//    private Boolean hasLower = false;
//    private Boolean hasDigit = false; 
//    private Boolean hasSpecial = false;
//    private Boolean okayLength = false;
//    private Boolean validLogin = false;
    
    private Boolean[] constraints = new Boolean[5];
    // constraints [0 - hasCaps, 1 - hasLower, 2 - hasDigit, 3 - hasSpecial, 4 - okayLength]
    
    // default constructor for UserLogin, is not used.
    UserLogin() {
        this.username = "default";
    }
    
    
    // constructor that takes in a string
    UserLogin(String u) {
        
        // sets the objects instance variable to the string provided
        this.username = u;
        
        // calls the method readUser which takes the provided string as a constraint 
        this.constraints = readUser(u);
    }
    
    public static void greetUser() {
        
        // prints an intoduction to the application, with istructions.
        System.out.println("Standard login screen.\n" + "Must Contain: \n" 
            + "- atleast one Uppercase letter and one Lowercase letter. \n"
            + "- atleast one digit and one of the following characters (!,@,#,$) \n" 
            + "- must be atleast 5 Characters Long. \n");
    }
    
    // takes a string and returns an array of booleans which reflects whether the 
    // string is valid
    public static Boolean[] readUser(String str) {
        Boolean[] rtn = new Boolean[5];
        rtn[0] = checkCase(str)[0]; // str contains Uppercase letters 
        rtn[1] = checkCase(str)[1]; // str contains Lowercase letters
        rtn[2] = checkForDigits(str); // str contains digits
        rtn[3] = checkForSpecial(str); // str contains special characters
        rtn[4] = checkLength(str); // str has no blank spaces and is long enough
        
        return rtn;
    }
    
    public void loginFromUser() {
        
    }
    
//    public void checkCase() {
//        for (int i = 0; i <= this.username.length(); i++){
//            if (this.hasCaps == false) {
//                this.hasCaps = (Character.isUpperCase(this.username.charAt(i)));
//            }
//            if (this.hasLower == false) {
//                this.hasLower = (Character.isLowerCase(this.username.charAt(i)));
//            }
//        }
//    }
    
    // takes a string and checks character by character to see if it contains a
    // either a lower case character or upper case character
    public static Boolean[] checkCase(String str) {
        Boolean hasCaps = false;
        Boolean hasLower = false;
        for (int i = 0; i < str.length(); i++) {
            if (hasCaps == false){
                hasCaps = (Character.isUpperCase(str.charAt(i)));
            }
            if (hasLower == false) {
                hasLower = (Character.isLowerCase(str.charAt(i)));
            }
        }
        Boolean[] rtn = new Boolean[2];
        
        rtn[0] = hasCaps;
        rtn[1] = hasLower;
        
        return rtn;
    }
    
//    public void checkLength() {
//        this.okayLength = (this.username.length() >= 5);
//    }
    
    // takes in a string and checks if its length is greater then or equal to 5
    // it then checks character by character to see if it contains blankspaces
    public static Boolean checkLength(String str) {
        Boolean noBlankSpaces = true;
        if (str.length() >= 5){
//            Boolean noBlankSpaces = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    noBlankSpaces = false;
                }
            }
            return noBlankSpaces;
        }
        else {return false;}
    }
    
    // takes in a string and checks character by character to see if it contains
    // a digit
    public static Boolean checkForDigits(String str) {
        Boolean hasDigit = false;
        for (int i = 0; i < str.length(); i++) {
            if (hasDigit == false) {
                hasDigit = (Character.isDigit(str.charAt(i)));
            }
        }
        return hasDigit;
    }
    
    // takes in a string and checks character by character to see of it contains
    // a !, @, #, or $
    public static Boolean checkForSpecial(String str) {
        Boolean hasSpecial = false;
        for (int i = 0; i < str.length(); i++) {
            if (hasSpecial == false) {
                hasSpecial = (str.charAt(i) == '!' || str.charAt(i) == '@' 
                        || str.charAt(i) == '#' || str.charAt(i) == '$');
            }
        }
        return hasSpecial;
    }
    
//    public void checkValidity() {
//        this.validLogin = (this.hasCaps && this.hasLower && this.hasDigit 
//                && this.hasSpecial && this.okayLength);
//    }
    
    
    // takes in an array of boolean and checks if the boolean at each position is 
    // true, if it is add one to the variable x, when it finishes running through 
    // the array it checks if x is equal to 5.
    public static Boolean checkValidity(Boolean[] bool) {
        int x = 0;
        
        for (Boolean bool1 : bool) {
            if (bool1 == true) {
                x++;
            }
        }
        return (x == 5);
    }
    
    // creates the error string from the objects string
    public String printUser(){
        String errorMessage = "";
        String formatting = "%s\n";
        if (checkValidity(this.constraints)) {
            errorMessage = String.format("%-25s%s\n", this.username, " (valid)");
        }
        else {
            errorMessage = String.format("%-25s%s\n", this.username, "(invalid)");
            
            if (!this.constraints[0]){
                errorMessage += String.format(formatting, "   -- no Uppercase Letter");
            }
            if (!this.constraints[1]){
                errorMessage += String.format(formatting, "   -- no Lowercase Letter");
            }
            if (!this.constraints[2]){
                errorMessage += String.format(formatting, "   -- no digit");
            }
            if (!this.constraints[3]){
                errorMessage += String.format(formatting, "   -- no Special Character");
            }
            if (!this.constraints[4]){
                errorMessage += String.format(formatting, "   -- needs to be atleast 5 Characters");
            }
        }
       
        return errorMessage;
    }
    
    public static void main(String[] args) {
        Boolean more = false;
        Boolean cont = false;
        String yesNo = "";
//        StringBuffer sb = new StringBuffer();
        
        greetUser();
        do {
            System.out.print("Login: ");
            UserLogin current = new UserLogin(in.nextLine());
            System.out.println(current.printUser());           
            UserLogin.addToReport(current);
//            sb.append(current.printUser());
            do{
                System.out.print("Do you have another user? (yes or no): ");
                yesNo = in.nextLine().toLowerCase();
                cont = (yesNo.equals("yes") || yesNo.equals("no"));
            } while (!cont);
            more = (yesNo.equals("yes"));
        } while (more);
        
        printReport(sb);
    }
    
    // adds the error message created from users input to the static string buffer
    public static void addToReport(UserLogin user) {
        sb.append(user.printUser());
        sb.append("\n ------------------------------ \n\n");
    }
    
    // prints the contents of the static string buffer to the file "report.txt"
    public static void printReport(StringBuffer strbuff) {
        try{
            PrintWriter out = new PrintWriter(new File("report.txt"));
            out.append(strbuff);
            out.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    
}
