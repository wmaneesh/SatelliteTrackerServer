package com.wmaneesh.satellitetracker.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wmaneesh.satellitetracker.model.Satellite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJsonFile {

    private static final Logger log = LoggerFactory.getLogger(ReadJsonFile.class);
    static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static List<Satellite> getSatellitesFromFile() {
        try {
            return mapper.readValue(new ClassPathResource("/satcatSatellites.json").getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, Satellite.class));
        } catch (IOException e) {
            log.error("e: ", e);
            throw new RuntimeException("cannot read file");
        }
    }
}
