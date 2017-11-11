package g2t.app.services;

import g2t.app.domain.Employee;
import g2t.app.domain.Section;
import g2t.app.repositories.EmployeeRepository;
import g2t.app.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private SectionRepository sectionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SectionRepository sectionRepository) {
        this.employeeRepository = employeeRepository;
        this.sectionRepository = sectionRepository;
    }

    public Iterable<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    public Iterable<Section> listSections(){ return sectionRepository.findAll(); }

    public Employee getEmployee(long rut){ return employeeRepository.findOne(rut); }

    public Employee saveEmployee(Employee device){ return employeeRepository.save(device); }

    public List<Employee> getActiveEmployees(){
        return employeeRepository.findByActive(true);
    }
}
