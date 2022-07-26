package service;

import model.Customer;

import java.util.*;

public class CustomerService {


   static Map<String,Customer> customerMap = new HashMap<String, Customer>();
   static  Set<Customer> customerSet = new HashSet<>();
   static Set<Customer> getCustomerSet = new HashSet<>();
    public static void addCustomer(String firstName, String lastName, String email){
       Customer customer = new Customer(firstName, lastName, email);
       customerSet.add(customer);
    }

    public static Customer getCustomer(String customerEmail){
        for (Customer c: customerSet
        ) {
            customerMap.put(c.getEmail(),c);
        }
      return  customerMap.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        for (Customer c: customerSet
             ) {
            getCustomerSet.add(getCustomer(c.getEmail()));
        }
       return getCustomerSet;
    }


}
