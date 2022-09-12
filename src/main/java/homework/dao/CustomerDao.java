package homework.dao;

import homework.model.Customer;

public interface CustomerDao {
    Customer findById(int id);
    void create(Customer customer);
    void update(Customer customer);
    void deleteById(int id);
}
