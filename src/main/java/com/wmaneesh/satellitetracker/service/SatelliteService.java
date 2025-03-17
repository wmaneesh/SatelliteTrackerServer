package com.wmaneesh.satellitetracker.service;

import com.wmaneesh.satellitetracker.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static com.wmaneesh.satellitetracker.utils.ReadJsonFile.*;

@Service
public class SatelliteService {

    private final WebClient webClient;
    private List<Satellite> storage;

    @Autowired
    public SatelliteService(WebClient webClient) {
        this.webClient = webClient;
        this.storage = new ArrayList<>();
    }

    public void fetchAllSatellites() {
        List<Satellite> allSatellites = webClient
                .get()
                .retrieve()
                .bodyToFlux(Satellite.class)
                .collectList()
                .block();

        storage.addAll(allSatellites);
    }

    public Flux<Satellite> getAllSatellitesFromApi() {
        return webClient
                .get()
                .retrieve()
                .bodyToFlux(Satellite.class);
    }

    public Flux<Satellite> getAllSatellitesFromFile() {
        return Flux.fromIterable(getSatellitesFromFile());
    }

    public void printFirstFewSatellites() {
        System.out.println(storage.size());
        storage.stream()
                .limit(10)
                .forEach(e -> System.out.println(e.getSatelliteName()));
    }
}
