package com.danicv.marvelservice.model;

import java.net.URI;
import java.util.List;

public record Comic(URI collectionURI,
                    int available,
                    List<Item> items) {
}
