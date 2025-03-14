package com.wmaneesh.satellitetracker.service;

import com.wmaneesh.satellitetracker.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static com.wmaneesh.satellitetracker.utils.ReadJsonFile.getSatellitesFromFile;

@Service
public class SatelliteService {

//    private final String URL = "https://celestrak.org/NORAD/elements/gp.php?GROUP=active&FORMAT=json";
    private final String BASE_URL = "https://celestrak.org/satcat/records.php?GROUP=active&FORMAT=JSON";

    private final WebClient webClient;

    private List<Satellite> storage;


    @Autowired
    public SatelliteService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl(BASE_URL).build();
        this.storage = new ArrayList<>();
    }

    public void fetchAllSatellites() {
        List<Satellite> allSatellites = webClient
                .get()
                .uri(BASE_URL)
                .retrieve()
                .bodyToFlux(Satellite.class)
                .collectList()
                .block();

        storage.addAll(allSatellites);
    }


    public Flux<Satellite> getAllSatellites() {
//        if (storage.isEmpty()) {
//            fetchAllSatellites();
//        }

//        return webClient
//                .get()
//                .uri(BASE_URL)
//                .retrieve()
//                .bodyToFlux(Satellite.class);

        return Flux.fromIterable(getSatellitesFromFile());
    }

    public void printFirstFewSatellites() {
        System.out.println(storage.size());
        storage.stream()
                .limit(10)
                .forEach(e -> System.out.println(e.getSatelliteName()));
    }
}
