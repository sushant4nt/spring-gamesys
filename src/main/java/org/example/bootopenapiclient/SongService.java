package org.example.bootopenapiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bootopenapi.url}")
    private String bootOpenApiUrl;

    public List<Song> getAllSongs() {
        ResponseEntity<List<Song>> responseEntity = restTemplate.exchange(
                        bootOpenApiUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Song>>() {});
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
