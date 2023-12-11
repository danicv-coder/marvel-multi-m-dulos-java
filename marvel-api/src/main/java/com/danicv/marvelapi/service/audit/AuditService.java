package com.danicv.marvelapi.service.audit;

import com.danicv.marvelapi.entity.AuditEntry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//Author: Daniel Calderon
@Component
public class AuditService {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Este metodo recibe por argumento un String con el nombre
     * del metodo ejecutado en el controlador CharacterController,
     * luego se crea una instancia de la entidad {@link AuditEntry}
     * Luego setean los atributos y se persiste la entidad en la BD.
     */
    @Transactional
    public void logAuditEntry(String methodName) {
        AuditEntry auditEntry = new AuditEntry();
        auditEntry.setExecutionTime(LocalDateTime.now());
        auditEntry.setMethodName(methodName);
        entityManager.persist(auditEntry);
    }
}
