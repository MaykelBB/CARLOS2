package g2t.app.controllers;

import g2t.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private EmployeeService testService;

    @Autowired
    public HomeController(EmployeeService testService) {
        this.testService = testService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle", "GPS2Track v 0.12");
        return "views/home";
    }
}
