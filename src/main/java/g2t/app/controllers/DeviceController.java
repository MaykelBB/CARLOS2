package g2t.app.controllers;

import g2t.app.domain.Device;
import g2t.app.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class DeviceController {
    private DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @RequestMapping("/dispositivo")
    public String deviceList(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Listado Dispositivos");
        model.addAttribute("devices", deviceService.getActiveDevices());
        return "views/devices/list";
    }

    @RequestMapping("/dispositivo/{imei}")
    public String showDevice(@PathVariable long imei, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Dispositivo ");
        model.addAttribute("device", deviceService.getDevice(imei));
        return "views/devices/show";
    }

    @RequestMapping("/dispositivo/nuevo")
    public String newDevice(Model model){
        model.addAttribute("pageTitle", "GPS2Track - Nuevo Dispositivo");
        model.addAttribute("readOnly", "false");
        model.addAttribute("device", new Device());
        return "views/devices/form";
    }

    @RequestMapping(value = "/dispositivo/save", method = RequestMethod.POST)
    public String saveDevice(@Valid Device device, BindingResult bindingResult, Model model){
        model.addAttribute("readOnly", "readonly");
        if (bindingResult.hasErrors()) return "views/devices/form";
        else {
            Device savedDevice = deviceService.saveDevice(device);
            return "redirect:/dispositivo/" + savedDevice.getImei();
        }
    }

    @RequestMapping("/dispositivo/editar/{imei}")
    public String editDevice(@PathVariable long imei, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Editar Dispositivo");
        model.addAttribute("readOnly", "readonly");
        model.addAttribute("device", deviceService.getDevice(imei));
        return "views/devices/form";
    }

    @RequestMapping("/dispositivo/eliminar/{imei}")
    public String deleteAssignment(@PathVariable long imei){
        Device updatedDevice = deviceService.getDevice(imei);
        updatedDevice.setActive(false);
        deviceService.saveDevice(updatedDevice);
        return "redirect:/dispositivo";
    }
}
