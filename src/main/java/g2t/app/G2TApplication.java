package g2t.app;

import g2t.app.domain.Device;
import g2t.app.domain.Employee;
import g2t.app.domain.Section;
import g2t.app.repositories.DeviceRepository;
import g2t.app.repositories.EmployeeRepository;
import g2t.app.repositories.SectionRepository;
import g2t.app.services.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class G2TApplication {

	private static final Logger logger = LoggerFactory.getLogger(G2TApplication.class);
	private SectionRepository sectionRepository;
	private EmployeeRepository employeeRepository;
	private DeviceRepository deviceRepository;
	private DataLoader dataLoader;

	@Autowired
	public G2TApplication(SectionRepository sectionRepository, EmployeeRepository employeeRepository, DeviceRepository deviceRepository,
						  DataLoader dataLoader) {
		this.sectionRepository = sectionRepository;
		this.employeeRepository = employeeRepository;
		this.deviceRepository = deviceRepository;
		this.dataLoader = dataLoader;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(G2TApplication.class, args);
		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);
		//for (String name : beans) System.out.println(name);
	}

	@PostConstruct
	void show(){
		for (Section sec : sectionRepository.findAll()){logger.info(sec.toString());}
		for (Employee emp : employeeRepository.findAll()){logger.info(emp.toString());}
		for (Device dev : deviceRepository.findAll()){logger.info(dev.toString());}
	}
}
