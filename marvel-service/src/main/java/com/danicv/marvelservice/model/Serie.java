package com.danicv.marvelservice.model;

import java.net.URI;
import java.util.List;

//Author: Daniel Calderon
public record Serie(URI collectionURI,
                    List<Item> items) {
}
