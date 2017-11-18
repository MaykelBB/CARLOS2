package g2t.app.controllers;

import g2t.app.domain.Assignment;
import g2t.app.services.AssignmentService;
import g2t.app.services.DeviceService;
import g2t.app.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AssignmentController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
    private AssignmentService assignmentService;
    private EmployeeService employeeService;
    private DeviceService deviceService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService, EmployeeService employeeService, DeviceService deviceService) {
        this.assignmentService = assignmentService;
        this.employeeService = employeeService;
        this.deviceService = deviceService;
    }

    @RequestMapping("/asignacion")
    public String AssignmentList(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Listado Asignaciones");
        model.addAttribute("assignments", assignmentService.getActiveAssignments());
        return "views/assignments/list";
    }

    @RequestMapping("/asignacion/{id}")
    public String showAssignment(@PathVariable long id, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Asignación");
        model.addAttribute("assignment", assignmentService.getAssignment(id));
        return "views/assignments/show";
    }

    @RequestMapping("/asignacion/nueva")
    public String newAssignment(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Nueva Asignación");
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("employees", employeeService.getAvailableEmployees());
        model.addAttribute("devices", deviceService.getAvailableDevices());
        return "views/assignments/form";
    }

    @RequestMapping(value = "/asignacion/save", method = RequestMethod.POST)
    public String saveAssignment(Assignment assignment){
        Assignment savedAssignment = assignmentService.saveAssignment(assignment);
        return "redirect:/asignacion/" + savedAssignment.getId();
    }

    @RequestMapping("/asignacion/editar/{id}")
    public String editAssignment(@PathVariable long id, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Editar Asignación");
        model.addAttribute("assignment", assignmentService.getAssignment(id));
        model.addAttribute("employees", employeeService.getAvailableEmployees());
        model.addAttribute("devices", deviceService.getAvailableDevices());
        return "views/assignments/form";
    }

    @RequestMapping("/asignacion/eliminar/{id}")
    public String deleteAssignment(@PathVariable long id){
        Assignment updatedAssignment = assignmentService.getAssignment(id);
        updatedAssignment.setActive(false);
        assignmentService.saveAssignment(updatedAssignment);
        return "redirect:/asignacion";
    }
}
