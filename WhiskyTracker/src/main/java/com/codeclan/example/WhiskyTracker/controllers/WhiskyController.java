package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getAllWhisky(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/byyear")
    public ResponseEntity<List<Whisky>> getAllWhiskyByYear(@RequestParam(name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/bydistilleryandyear")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(@RequestParam(name = "distilleryName") String distilleryName, @RequestParam(name = "age") int age) {
        Distillery distillery = distilleryRepository.findDistilleryByName(distilleryName);
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryAndAge(distillery, age), HttpStatus.OK);
    }

//    @GetMapping(value = "/whisky/byregion")
//    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name = "region") String region){
//        List<Distillery> distilleries = distilleryRepository.findDistilleryByRegion(region);
//        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistillery(distilleries), HttpStatus.OK);
//
//    }

    @GetMapping(value = "/whisky/byregion")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
    }
}
