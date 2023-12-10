package com.danicv.marvelservice.service.api.impl;

import com.danicv.marvelservice.model.Character;
import com.danicv.marvelservice.service.api.CharacterService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.Map;

//Author: Daniel Calderon
public class CharacterServiceImpl implements CharacterService {

    private final RestClient restClient;

    public CharacterServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Character getCharacter() {
        return restClient.get().uri("/characters").retrieve().body(new ParameterizedTypeReference<Character>() {
        });
    }

    @Override
    public Character getCharacterId(String id) {
        var result = restClient.get().uri("/characters/{id}", Map.of("id", id))
                .retrieve()
                .body(new ParameterizedTypeReference<Character>() {
                });
        return result;
    }
}
