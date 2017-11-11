package g2t.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

    @RequestMapping("/reportes")
    public String showReport(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Reportes");
        return "views/reports/show";
    }
}
