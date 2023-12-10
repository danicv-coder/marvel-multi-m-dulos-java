package com.danicv.marvelservice.errors;

//Author: Daniel Calderon
public class CharacterNotFound extends RuntimeException {
    private CharacterNotFound(String id) {
        super(String.format("Character not found with id = %s", id));
    }

    public static CharacterNotFound create(String id) {
        return new CharacterNotFound(id);
    }

}
