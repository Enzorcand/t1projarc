package com.example.demo2.controller;


import com.example.demo2.model.ACMERent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/acmerent")
@RestController
public class ACMERentController {


    private ACMERent system;


    public ACMERentController() {
        system = new ACMERent();
    }


}
