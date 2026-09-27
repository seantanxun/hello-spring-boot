package com.example.hellospringboot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

	private static final DateTimeFormatter TIME_FORMATTER =
			DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	private final TimeRecordRepository timeRecordRepository;

	public HelloController(TimeRecordRepository timeRecordRepository) {
		this.timeRecordRepository = timeRecordRepository;
	}

	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/api/time")
	public Map<String, String> serverTime() {
		String currentTime = LocalDateTime.now().format(TIME_FORMATTER);
		timeRecordRepository.save(new TimeRecord(currentTime));
		log.info("==================================================");
		log.info("收到前端获取时间请求");
		log.info("返回服务器时间: {}", currentTime);
		log.info("==================================================");

		return Map.of(
				"message", "这条信息来自 Spring Boot 后端",
				"time", currentTime);
	}
}
