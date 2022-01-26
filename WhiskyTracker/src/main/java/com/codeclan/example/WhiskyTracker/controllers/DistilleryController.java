package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distillery")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distillery/getbyname")
    public ResponseEntity<Distillery> getDistilleryByName(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(distilleryRepository.findDistilleryByName(name), HttpStatus.OK);
    }


    @GetMapping(value = "/distillery/byregion")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distillery/bywhiskyage")
    public ResponseEntity<List<Distillery>> getAllDistilleriesByWhiskyAge(@RequestParam(name = "age") int age){
        return new ResponseEntity<>(distilleryRepository.findDistilleryByWhiskiesAge(age), HttpStatus.OK);
    }

}
