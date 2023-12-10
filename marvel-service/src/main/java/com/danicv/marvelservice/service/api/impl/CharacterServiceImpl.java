package com.danicv.marvelservice.service.api.impl;

import com.danicv.marvelservice.errors.CharacterNotFound;
import com.danicv.marvelservice.model.Character;
import com.danicv.marvelservice.service.api.CharacterService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

//Author: Daniel Calderon
public class CharacterServiceImpl implements CharacterService {

    private final RestClient restClient;

    public CharacterServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Este metodo obtiene los personajes de la api de developer Marvel.
     * se realiza una solicitud al servicio characterService que es el en cargado
     * de consumir el endpoint character de la api y se procesa la respuesta para
     * obtener la lista de personajes.
     */

    @Override
    public Character getCharacter() {
        return restClient.get().uri("/characters")
                .retrieve()
                .body(new ParameterizedTypeReference<Character>() {
                });
    }

    /**
     * Este metodo obtiene un personaje dado un id de la api de developer Marvel.
     * se realiza una solicitud al servicio characterService que es el en cargado
     * de consumir el endpoint character/{characterId} de la api y se procesa la respuesta para
     * obtener un personaje. En caso de error de que no se encuntre el personaje dado el id
     * se lanza una excepcion personalizada de tipo {@link CharacterNotFound}.
     */

    @Override
    public Character getCharacterId(String id) {
        return restClient.get().uri("/characters/{id}", Map.of("id", id))
                .retrieve()
                .onStatus(status -> status.isSameCodeAs(NOT_FOUND), (request, response) -> {
                    throw CharacterNotFound.create(id);
                })
                .body(new ParameterizedTypeReference<Character>() {
                });
    }
}
