import java.util.*;

public class DataBase {
    private List<Customer> customers = new ArrayList<>();

    public DataBase() {
        customers.add(new Customer("maha", 7339249, "Mbhb@223",150));
        customers.add(new Customer("bhuvana", 6382661, "Chu@223",200));
        customers.add(new Customer("gomathi", 8610754, "Go@223",250));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}