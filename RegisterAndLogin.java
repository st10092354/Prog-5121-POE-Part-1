package com.lerato.registerandlogin;
/**
 @author leratokekana
*/

//java imports
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterAndLogin {
    
    //declarations for ArrayLists
    static List<String> firstName = new ArrayList<>();
    static List<String> lastName = new ArrayList<>();
    static List<String> username = new ArrayList<>();
    static List<String> password = new ArrayList<>();
    
    //declarationfor scanner item
    static Scanner s = new Scanner(System.in);
    
    //main method
    public static void main(String[] args) {
        System.out.println("Create an account");
        
        //calling login method
        RegisterAcc();
        
    }
    
    //creating login class
    public static void RegisterAcc() {
        
        System.out.println("Enter your first name: ");
        String name;
        name = s.next();
        //saving name to arraylist
        firstName.add(name);
        
        System.out.println("Enter your last name: ");
        String lName;
        lName = s.next();
        //saving name to arraylist
        lastName.add(lName);
        
        captureUsername();
        createPassword();
        
    }
    public static void captureUsername(){
        System.out.println("Enter a username: ");
        System.out.println("Your username must be 5 or less characters long");
        System.out.println("Your username must also contain an underscore (_) ");
        
        String uName;
        uName = s.next();
        char underscore = '_';
        String underscoreString = new String(new char[]{underscore});
        
        if(uName.length() <= 5 && uName.contains(underscoreString)){
            username.add(uName);
            System.out.println("Username Successfully captured");
        }
        else{
            System.out.println("Username is not correctly formatted");
            captureUsername();
        }
    }
    
    
    public static void createPassword(){
        
        System.out.println("""
                           Create a password: 
                           Your password must: 
                           Be at least 8 characters long
                           Contain a capital letter
                           Contain a number
                           Contain a special charcter""");
        
        String pass;
        pass = s.next();
        
        if( pass.length() >= 8 &&
            !pass.equals(pass.toLowerCase()) &&
            !pass.equals(pass.toUpperCase()) &&
            pass.contains("!@#$%^&*")
        ){
            password.add(pass);
            System.out.println("Password successfully captured");
        }
        else{
            System.out.println("Your password is not correctly captured");
            createPassword();
        }
        
        
    }
    
    public static void loginSystem(){
        HashMap<String, String> users = new HashMap<>();
        
        System.out.println("Welcome to the login system!");
        System.out.print("Enter your username: ");
        String uName = s.nextLine();
        System.out.print("Enter your password: ");
        String pWord = s.nextLine();
        
        //if statement to print out pass word
        if(uName.matches(uName) && (pWord.matches(pWord))){
            System.out.println("Welcome " + firstName + lastName);
        }
            
        else {
            System.out.println("Login failed. Please try again.");
            loginSystem();
        }
        
    }
    //boolean method to check password complexity
    boolean checkPasswordComplexity(String password){
        String regex = "^(?=.*[0-9]"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }
    //boolean testing method for username
    boolean checkUserName(String username){
        return !(username.length() >= 5 || username.indexOf('_') == -1);
    }
    //boolean testing method for password
    boolean loginUser(String username, String password){
        return username.equals(this.username) && password.equals(this.password);
    }
}
    


