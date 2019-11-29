package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("companys",companyRepository.findAll());
        return "index";
    }

    @GetMapping("/companyform")
    public String companyform(Model model){
        model.addAttribute("company",new company());
        return "companyForm";
    }

    @PostMapping("/companyform")
    public String process(@Valid company company, BindingResult result){
        if(result.hasErrors()){
            return "companyForm";
        }

        companyRepository.save(company);
            return "redirect:/";
        }

}
