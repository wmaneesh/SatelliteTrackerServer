package com.wmaneesh.satellitetracker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    //    private final String URL = "https://celestrak.org/NORAD/elements/gp.php?GROUP=active&FORMAT=json";
    private final String BASE_URL = "https://celestrak.org/satcat/records.php?GROUP=active&FORMAT=JSON";

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(BASE_URL).build();
    }


}
