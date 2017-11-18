package g2t.app.controllers;

import g2t.app.domain.Device;
import g2t.app.services.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeviceController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);
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
    public String saveDevice(Device device){
        Device savedDevice = deviceService.saveDevice(device);
        return "redirect:/dispositivo/" + savedDevice.getImei();
    }

    @RequestMapping("/dispositivo/editar/{imei}")
    public String editDevice(@PathVariable long imei, Model model){
        model.addAttribute("pageTitle", "GPS2Track - Editar Dispositivo");
        model.addAttribute("readOnly", "readonly");
        model.addAttribute("device", deviceService.getDevice(imei));
        return "views/devices/form";
    }

    @RequestMapping("/dispositivo/eliminar/{id}")
    public String deleteAssignment(@PathVariable long imei){
        Device updatedDevice = deviceService.getDevice(imei);
        updatedDevice.setActive(false);
        deviceService.saveDevice(updatedDevice);
        return "redirect:/dispositivo";
    }
}
