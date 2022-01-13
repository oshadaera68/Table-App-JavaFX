/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package db;

import model.Customer;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerTable = new ArrayList();

    static {
        customerTable.add(
                new Customer("C001", "Nimal", "Colombo", 25000)
        );
        customerTable.add(
                new Customer("C002", "Amal", "ahangama", 30000)
        );
        customerTable.add(
                new Customer("C003", "kamal", "aluthgama", 34000)
        );
    }
}
