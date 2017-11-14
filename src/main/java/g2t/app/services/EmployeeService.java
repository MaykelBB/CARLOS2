package g2t.app.services;

import g2t.app.domain.Employee;
import g2t.app.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long rut){ return employeeRepository.findOne(rut); }

    public Employee saveEmployee(Employee employee){ return employeeRepository.save(employee); }

    public List<Employee> getActiveEmployees(){
        return employeeRepository.findByActive(true);
    }

    public List<Employee> getAvailableEmployees(){ return employeeRepository.findAvailable(); }
}
