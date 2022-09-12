package homework.sevice.impl;

import homework.dao.CustomerDao;
import homework.model.Customer;
import homework.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.findById(id);
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDao.deleteById(id);
    }
}
