package com.bluewind.exports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Home Page
    @GetMapping("/")
    public String home() {
        return "Home";
    }

    // Exports Page
    @GetMapping("/exports")
    public String exports() {
        return "Exports";
    }

    // Imports Page
    @GetMapping("/imports")
    public String imports() {
        return "Imports";
    }

    // Contact Page
    @GetMapping("/contact")
    public String contact() {
        return "Contact";
    }

    // About Page
    @GetMapping("/about")
    public String about() {
        return "AboutUs";
    }

    //Textiles
    @GetMapping("/textiles")
    public String textiles(){
        return "Textiles";
    }

    @GetMapping("/furniture")
    public String furniture(){
        return "Furniture";
    }

    @GetMapping("/agriculture")
    public String agriculture(){
        return "AgricultureEquipments";
    }

    // Contact Page
    @GetMapping("/certification")
    public String certification() {
        return "Certification";
    }


    @GetMapping("/enquiry")
    public String enquiry(){
        return "Enquiry";
    }
}
