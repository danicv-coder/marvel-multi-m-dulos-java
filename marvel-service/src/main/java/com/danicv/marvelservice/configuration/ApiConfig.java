package com.danicv.marvelservice.configuration;

import com.danicv.marvelservice.service.api.CharacterService;
import com.danicv.marvelservice.service.api.impl.CharacterServiceImpl;
import com.danicv.marvelservice.utils.MarvelApiUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//Author: Daniel Calderon
@Configuration
public class ApiConfig {
    @Bean
    CharacterService instance(@Qualifier("marvelClient") RestClient restClient) {
        return new CharacterServiceImpl(restClient);
    }

    @Bean("marvelClient")
    RestClient characterRestClient(@Value("${url}") String url,
                                   @Value("${private.key}") String privateKey,

                                   @Value("${public.key}") String publicKey) {
        return RestClient.builder()
                .baseUrl(url)
                .requestInterceptor((request, body, execution) -> {
                    long timestamp = System.currentTimeMillis();

                    var hash = MarvelApiUtils.computerHash(publicKey, privateKey, timestamp);

                    URI uri = UriComponentsBuilder.fromUri(request.getURI())
                            .queryParam("apikey", publicKey)
                            .queryParam("hash", hash)
                            .queryParam("ts", timestamp)
                            .build().toUri();
                    var newRequest = new HttpRequestWrapper(request) {
                        @Override
                        @NonNull
                        public URI getURI() {
                            return uri;
                        }
                    };
                    return execution.execute(newRequest, body);
                })
                .build();
    }
}
