package crm.crmsystem.controller;

import crm.crmsystem.model.ApplicationRequest;
import crm.crmsystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String homePage(Model model){
    model.addAttribute("applications", applicationService.getAllApplications());
        return "home";
    }

    @GetMapping("/add")
    public String addPage(){
        return "addApp";
    }

    @PostMapping("/application/add")
    public String add(ApplicationRequest applicationRequest){
        applicationService.addApplications(applicationRequest);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newPage(Model model){
        model.addAttribute("applications", applicationService.getAllApplications());
        return "newApps";
    }

    @GetMapping("/old")
    public String oldPage(Model model){
        model.addAttribute("applications", applicationService.getAllApplications());
        return "oldApps";
    }


    @GetMapping("/application/{id}")
    public String editPage(@PathVariable Long id, Model model){
        ApplicationRequest applications = applicationService.getApplicationById(id);
        model.addAttribute("applications", applications);
        return "edit";
    }

    @PostMapping("/application/edit")
    public String edit(ApplicationRequest applicationRequest){
        applicationService.editApplication(applicationRequest);
        return "redirect:/";
    }

    @PostMapping("/application/delete")
    public String delete(Long id){
        applicationService.deleteApplication(id);
        return "redirect:/";
    }
}
