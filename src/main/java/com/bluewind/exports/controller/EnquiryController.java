package com.bluewind.exports.controller;

import com.bluewind.exports.entity.Enquiry;
import com.bluewind.exports.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping("/submit-enquiry")
    public String submitEnquiry(Enquiry enquiry) {

        // SAVE enquiry into database
        enquiryRepository.save(enquiry);

        // redirect after successful submit
        return "redirect:/enquiry?success";
    }
}
