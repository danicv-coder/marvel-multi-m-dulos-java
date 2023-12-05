package com.danicv.marvelservice.service.api.impl;

import com.danicv.marvelservice.model.Character;

//Author: Daniel Calderon
public interface CharacterService {
    Character getCharacter();

    Character getCharacterId(String id);
}
