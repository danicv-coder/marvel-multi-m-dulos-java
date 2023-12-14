package com.danicv.marvelapi.configuration;

import com.danicv.marvelapi.aspect.AuditAspect;
import com.danicv.marvelapi.service.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Author: Daniel Calderon
@Configuration
public class AudiConfig {
    private final AuditService auditService;

    public AudiConfig(@Autowired AuditService auditService) {
        this.auditService = auditService;
    }

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect(auditService);
    }
}


