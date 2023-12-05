package com.danicv.marvelservice.model;

import java.util.Date;

//Author: Daniel Calderon
public record Result(Integer id,
                     String name,
                     String description,
                     Date modified,
                     Comic comics,
                     Serie series,
                     Event events
) {
}
