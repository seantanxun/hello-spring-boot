package com.example.hellospringboot;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeRecordRepository extends MongoRepository<TimeRecord, String> {
}
