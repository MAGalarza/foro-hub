package com.aluracursos.forohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${omdb.api.url}")
    private String omdbApiUrl;

    @Value("${omdb.api.key}")
    private String omdbApiKey;

    public Map<String, Object> getMovieDetails(String title) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(omdbApiUrl)
                .queryParam("apikey", omdbApiKey)
                .queryParam("t", title);

        return restTemplate.getForObject(uriBuilder.toUriString(), Map.class);
    }
}