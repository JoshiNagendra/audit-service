package com.joshi.listener;

import com.joshi.service.AuditService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditKafkaListener {

    @Autowired
    private AuditService auditService;

    @KafkaListener(topics = {"document.uploaded", "document.processed", "document.failed"})
    public void listen(ConsumerRecord<String,String> record){
        auditService.logEvent(
                record.topic(),
                "RECEIVED",
                "UNKNOWN",
                record.value()
        );
    }

}
