package com.example.hellospringboot;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "server_time_records")
public class TimeRecord {

	@Id
	private String id;
	private String serverTime;
	private Instant createdAt;

	protected TimeRecord() {
	}

	public TimeRecord(String serverTime) {
		this.serverTime = serverTime;
		this.createdAt = Instant.now();
	}

	public String getId() {
		return id;
	}

	public String getServerTime() {
		return serverTime;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}
}
