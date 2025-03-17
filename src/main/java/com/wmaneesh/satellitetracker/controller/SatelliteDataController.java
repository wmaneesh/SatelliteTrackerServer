package com.wmaneesh.satellitetracker.controller;

import com.wmaneesh.satellitetracker.model.Satellite;
import com.wmaneesh.satellitetracker.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("satellite/api/")
public class SatelliteDataController {
    private final SatelliteService satelliteService;

    @Autowired
    public SatelliteDataController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @GetMapping("/all")
    public Flux<Satellite> getAllSatellites() {
        return satelliteService.getAllSatellitesFromApi();
    }

    @GetMapping("/all/fromFile")
    public Flux<Satellite> getAllSatellitesFromFile() {
        return satelliteService.getAllSatellitesFromFile();
    }

    @PostMapping("/stripeTest")
    public void getJson(@RequestBody String json) {
        satelliteService.testingStripe(json);
    }
}
