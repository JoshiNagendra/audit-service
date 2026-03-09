package com.joshi.service;

import com.joshi.entity.AuditLog;
import com.joshi.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository repository;

    public void logEvent(String topic,String eventType, String sourceService,String payload){
        AuditLog log = new AuditLog();
        log.setTopic(topic);
        log.setEventType(eventType);
        log.setSourceService(sourceService);
        log.setPayload(payload);
        log.setTimestamp(Instant.now());
        repository.save(log);
    }
}
