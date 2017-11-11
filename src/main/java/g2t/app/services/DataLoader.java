package g2t.app.services;

import g2t.app.domain.Device;
import g2t.app.domain.Employee;
import g2t.app.domain.Section;
import g2t.app.domain.enums.Genre;
import g2t.app.repositories.DeviceRepository;
import g2t.app.repositories.EmployeeRepository;
import g2t.app.repositories.SectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.sql.Date;


@Service
public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private EmployeeRepository employeeRepository;
    private SectionRepository sectionRepository;
    private DeviceRepository deviceRepository;

    @Autowired
    public DataLoader(EmployeeRepository employeeRepository, SectionRepository sectionRepository, DeviceRepository deviceRepository) {
        this.employeeRepository = employeeRepository;
        this.sectionRepository = sectionRepository;
        this.deviceRepository = deviceRepository;
    }


    public void dataLoad(){
        Section s1 = new Section("Desarrollo");
        Section s2 = new Section("QA");
        sectionRepository.save(s1);
        sectionRepository.save(s2);
        employeeRepository.save(new Employee(1528220202L, "Carlos", "Rios", "Stange", Date.valueOf("1982-06-02"), Genre.M, "Software", s1));
        employeeRepository.save(new Employee(1645845206L, "Karina", "Flores", "Acevedo", new Date(601265900000L), Genre.F, "Tester", s2));
        deviceRepository.save(new Device(484151548545110L,"Casio", "L548","T57f3j680"));
        deviceRepository.save(new Device(547815874458774L,"Casio", "L521","T52ff640L", false));
        deviceRepository.save(new Device(862743030713269L,"Xiaomi", "Mi Note 2","9620b89e"));
        deviceRepository.save(new Device(862743030713277L,"Xiaomi", "Mi Note 2","5rtY560x"));
    }
}
