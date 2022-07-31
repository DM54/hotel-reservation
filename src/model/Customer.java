package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the Customer Class
 * Where it has three variables firstname, lastname, and email
 * another string called regex to validate an email following the regex pattern.
 * @author Dyana Monroy
 */
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    String emailRegEx = "^(.+)@(.+).(.+)$";
    Pattern pattern = Pattern.compile(emailRegEx);


    public Customer(String firstName, String lastName, String email){
        if(!pattern.matcher(email).matches()){
        throw new IllegalArgumentException("It is invalid email.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return " Name: " + firstName +" " + lastName + " Email: " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.equals(null)){
            return false;
        }
        return getFirstName().equals(this.getFirstName());
    }

    public boolean LastNameequals(Object obj) {
        if(obj.equals(null)){
            return false;
        }
        return getLastName().equals(this.getLastName());
    }


    @Override
    public int hashCode() {
        return (int) firstName.hashCode();
    }

    public int LastNamehashCode() {
        return (int) lastName.hashCode();
    }

    public int EmailhashCode() {
        return (int) email.hashCode();
    }


}
