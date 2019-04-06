package com.startup.java.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startup.java.training.service.Client;

@RestController
public class SlackNotifier {
	
	@Autowired
	Client client;
	
	@PostMapping(value = "/notifyToSlack", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String notifyToSlack(HttpEntity<String> httpEntity) {
		String payload = httpEntity.getBody();
		
		try {
		client.notify(payload);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"Message\": \"Notification Failed\"}";
		}
		
		return "{\"Message\": \"Notified Successfully\"}";
	}
	
}
