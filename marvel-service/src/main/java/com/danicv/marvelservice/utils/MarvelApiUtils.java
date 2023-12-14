package com.danicv.marvelservice.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

//Author: Daniel Calderon
public class MarvelApiUtils {
    public static String computerHash(String publicKey,
                                      String privateKey,
                                      long timestamp) {
        return DigestUtils.md5DigestAsHex(String.format("%d%s%s", timestamp, privateKey, publicKey).getBytes(StandardCharsets.UTF_8));
    }
}
