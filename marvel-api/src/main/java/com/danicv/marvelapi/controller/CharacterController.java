package com.danicv.marvelapi.controller;

import com.danicv.marvelapi.aspect.Audit;
import com.danicv.marvelservice.model.Character;
import com.danicv.marvelservice.service.api.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Author: Daniel Calderon
@RestController
@RequestMapping("/marvel")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(@Autowired CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/characters", produces = "application/json")
    @Audit
    public Character getCharacter() {
        return characterService.getCharacter();
    }

    @GetMapping(value = "/characters/{characterId}")
    @Audit
    public Character getCharacterById(@PathVariable String characterId) {
        return characterService.getCharacterId(characterId);
    }
}
