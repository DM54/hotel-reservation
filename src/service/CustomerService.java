package service;

import model.Customer;
import java.util.*;

public class CustomerService {


   private static Map<String,Customer> customerMap = new HashMap<String, Customer>();
   private static  Set<Customer> customerSet = new HashSet<>();
   private static Set<Customer> getCustomerSet = new HashSet<>();

   private static CustomerService Instance;

   private CustomerService(){

   }

   public static CustomerService getInstance(){
       if(Instance==null){
           Instance = new CustomerService();
       }
       return Instance;
   }

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
