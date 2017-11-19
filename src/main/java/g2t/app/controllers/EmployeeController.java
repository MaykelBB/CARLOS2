package g2t.app.controllers;

import g2t.app.domain.Employee;
import g2t.app.services.EmployeeService;
import g2t.app.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private SectionService sectionService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, SectionService sectionService) {
        this.employeeService = employeeService;
        this.sectionService = sectionService;
    }

    @RequestMapping("/trabajador")
    public String employeeList(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Listado Trabajadores");
        model.addAttribute("employees", employeeService.getActiveEmployees());
        return "views/employees/list";
    }

    @RequestMapping("/trabajador/{rut}")
    public String showEmployee(@PathVariable long rut, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Trabajador");
        model.addAttribute("employee", employeeService.getEmployee(rut));
        return "views/employees/show";
    }

    @RequestMapping("/trabajador/nuevo")
    public String newEmployee(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Nuevo Trabajador");
        model.addAttribute("readOnly", "false");
        model.addAttribute("employee", new Employee());
        model.addAttribute("sections", sectionService.getActiveSections());
        return "views/employees/form";
    }

    @RequestMapping(value = "/trabajador/save", method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("readOnly", "readonly");
            model.addAttribute("sections", sectionService.getActiveSections());
            return "views/employees/form";
        }
        else {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return "redirect:/trabajador/" + savedEmployee.getRut();
        }
    }

    @RequestMapping("/trabajador/editar/{rut}")
    public String editEmployee(@PathVariable long rut, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Editar Trabajador");
        model.addAttribute("readOnly", "readonly");
        model.addAttribute("employee", employeeService.getEmployee(rut));
        model.addAttribute("sections", sectionService.getActiveSections());
        return "views/employees/form";
    }

    @RequestMapping("/trabajador/eliminar/{rut}")
    public String deleteAssignment(@PathVariable long rut){
        Employee updatedEmployee = employeeService.getEmployee(rut);
        updatedEmployee.setActive(false);
        employeeService.saveEmployee(updatedEmployee);
        return "redirect:/trabajador";
    }
}
