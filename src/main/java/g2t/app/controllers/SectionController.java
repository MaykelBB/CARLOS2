package g2t.app.controllers;

import g2t.app.domain.Section;
import g2t.app.services.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SectionController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
    private SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping("/seccion")
    public String sectionList(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Listado Secciones");
        model.addAttribute("sections", sectionService.getActiveSections());
        return "views/sections/list";
    }

    @RequestMapping("/seccion/{id}")
    public String showSection(@PathVariable long id, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Seccion");
        model.addAttribute("section", sectionService.getSection(id));
        return "views/sections/show";
    }

    @RequestMapping("/seccion/nueva")
    public String newSection(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Nueva Sección");
        model.addAttribute("section", new Section());
        return "views/sections/form";
    }

    @RequestMapping(value = "/seccion/save", method = RequestMethod.POST)
    public String saveSection(Section section){
        logger.info(String.valueOf(section.getId()));
        Section savedSection = sectionService.saveSection(section);
        return "redirect:/seccion/" + savedSection.getId();
    }

    @RequestMapping("/seccion/editar/{id}")
    public String editSection(@PathVariable long id, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Editar Sección");
        model.addAttribute("section", sectionService.getSection(id));
        return "views/sections/form";
    }

    @RequestMapping("/seccion/eliminar/{id}")
    public String deleteAssignment(@PathVariable long id){
        Section updatedSection = sectionService.getSection(id);
        updatedSection.setActive(false);
        sectionService.saveSection(updatedSection);
        return "redirect:/seccion";
    }
}
