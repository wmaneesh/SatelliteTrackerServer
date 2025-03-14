package com.wmaneesh.satellitetracker;

import com.wmaneesh.satellitetracker.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SatelliteTrackerApplication {

    public static void main(String[] args) {
		SpringApplication.run(SatelliteTrackerApplication.class, args);
//
//		SatelliteService satelliteService = context.getBean(SatelliteService.class);
//
//		satelliteService.getAllSatellites();
//		satelliteService.printFirstFewSatellites();
	}

}
