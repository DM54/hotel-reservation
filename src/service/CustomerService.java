package service;

import model.Customer;

import java.util.*;

public class CustomerService {


   static Map<String,Customer> customerMap = new HashMap<String, Customer>();
   static ArrayList<Customer> customerList = new ArrayList<Customer>();
    public static void addCustomer(String firstName, String lastName, String email){
       Customer customer = new Customer(firstName, lastName, email);
       customerList.add(customer);

       // System.out.println(" From addCustomer method: " + customerList);
    }

    public static Customer getCustomer(String customerEmail){
        System.out.println(" From getCustomer method ");
        for (Customer c: customerList
        ) {
            customerMap.put(c.getEmail(),c);
        }
      return  customerMap.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers(){
        System.out.println(" From getAllCustomers method ");
      for (int i=0; i<customerList.size(); i++){
          customerList.get(i);
      }
       return customerList;
    }


}
