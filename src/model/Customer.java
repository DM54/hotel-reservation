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
    private String firstName;
    private String lastName;
    private String email;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return " Name: " + firstName +" " + lastName + " Email: " + email;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
