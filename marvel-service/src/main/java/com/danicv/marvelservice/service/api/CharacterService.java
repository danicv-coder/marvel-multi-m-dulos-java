package com.danicv.marvelservice.service.api;

import com.danicv.marvelservice.model.Character;

//Author: Daniel Calderon
public interface CharacterService {
    Character getCharacter();

    Character getCharacterId(String id);
}
