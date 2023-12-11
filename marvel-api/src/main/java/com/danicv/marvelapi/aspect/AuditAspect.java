package com.danicv.marvelapi.aspect;

import com.danicv.marvelapi.service.audit.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Author: Daniel Calderon
@Aspect
@Component
public class AuditAspect {
    private final AuditService auditService;

    public AuditAspect(@Autowired AuditService auditService) {
        this.auditService = auditService;
    }

    /**
     * Este método es un Aspecto que se ejecuta antes de la ejecución
     * de cualquier método anotado con @Audit. La anotación @Before asegura
     * que este advice se ejecute previamente al método objetivo.
     *
     * @param joinPoint Objeto que proporciona información sobre el punto de
     *                  ejecución del programa,específicamente el método que está a punto de
     *                  ejecutarse.
     */
    @Before("@annotation(Audit)")
    public void logAuditEntry(JoinPoint joinPoint) {
        String methodName = getMethodName(joinPoint);
        auditService.logAuditEntry(methodName);
    }

    /**
     * Este metodo recibe por argumento un objeto {@link JoinPoint}
     * el cual representa un punto específico en la ejecución de un metodo.
     * El objeto {@link Signature} Proporciona información sobre el método que se
     * está ejecutando en ese momento y se le pasa el nombre y lo retorna.
     */
    public String getMethodName(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        return signature.getName();
    }
}
