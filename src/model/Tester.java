package model;

public class Tester {

    public static void main(String [] args){
        Customer customer = new Customer("first", "last", "j@domain.com");

        System.out.println(customer);

       Customer customer1 = new Customer("first", "last", "email");
       System.out.println(customer1);
    }
}
