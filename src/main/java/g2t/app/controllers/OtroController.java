package g2t.app.controllers;

import g2t.app.domain.Employee;
import g2t.app.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OtroController {

    @Value("${server.port}")
    private String value;

    @Autowired
    EmployeeRepository repo;

    @RequestMapping("/otro")
    public String home(){
        List<String> out = new ArrayList<>();
        for (Employee emp : repo.findAll()){ out.add(emp.toString()); }
        out.add("Esta es otra pagina con el puerto " + value);
        return out.toString();

    }
}
