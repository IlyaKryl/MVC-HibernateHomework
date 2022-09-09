package homework.sevice;

import homework.model.Customer;

public interface CustomerService {
    Customer getCustomer(int id);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
