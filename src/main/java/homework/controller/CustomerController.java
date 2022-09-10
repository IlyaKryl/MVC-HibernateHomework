package homework.controller;

import homework.dto.CustomerFormDto;
import homework.model.Customer;
import homework.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerFormDto customerDto) {
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullName());
        customer.setCompany(customerDto.getCompany());
        customer.setProjects(customerDto.getProjects());

        customerService.createCustomer(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id,
                                                   @RequestBody CustomerFormDto customerDto) {
        Customer customer = customerService.getCustomer(id);
        customer.setFullName(customerDto.getFullName());
        customer.setCompany(customerDto.getCompany());
        customer.setProjects(customerDto.getProjects());

        customerService.updateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
