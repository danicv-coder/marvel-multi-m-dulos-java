package com.danicv.marvelservice.model;

import java.net.URI;

//Author: Daniel Calderon
public record Item(String name,
                   URI resourceURI,
                   String type) {
}
