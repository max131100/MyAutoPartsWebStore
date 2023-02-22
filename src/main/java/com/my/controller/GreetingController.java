package com.my.controller;

import com.my.entity.Part;
import com.my.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private PartRepository partRepo;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("some", "It's my Parts Store");
        Iterable<Part> parts = partRepo.findAll();
        model.addAttribute("parts", parts);
        return "main";
    }

    @GetMapping("/admin")
    public String adminMain(Model model) {
        model.addAttribute("some", "It's my Parts Store");
        Iterable<Part> parts = partRepo.findAll();
        model.addAttribute("parts", parts);
        return "adminMain";
    }

    @PostMapping("/admin")
    public String add(@RequestParam String manufacturer,
                      @RequestParam String article,
                      @RequestParam String description,
                      @RequestParam Integer price,
                      @RequestParam Integer qtyOnHand, Model model) {
        partRepo.save(new Part(manufacturer, article, description, price, qtyOnHand));
        Iterable<Part> parts = partRepo.findAll();
        model.addAttribute("parts", parts);
        return "adminMain";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String descriptionFilter, Model model) {
        Iterable<Part> parts;
        if(descriptionFilter != null && !descriptionFilter.isEmpty()) {
            parts = partRepo.findByDescription(descriptionFilter);
        } else {
            parts = partRepo.findAll();
        }
        model.addAttribute("parts", parts);
        return "main";
    }

    @PostMapping("adminFilter")
    public String adminFilter(@RequestParam String descriptionFilter, Model model) {
        Iterable<Part> parts;
        if(descriptionFilter != null && !descriptionFilter.isEmpty()) {
            parts = partRepo.findByDescription(descriptionFilter);
        } else {
            parts = partRepo.findAll();
        }
        model.addAttribute("parts", parts);
        return "adminMain";
    }
}
