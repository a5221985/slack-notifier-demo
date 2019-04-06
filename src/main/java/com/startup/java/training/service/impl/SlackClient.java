package com.startup.java.training.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.startup.java.training.service.Client;

@Service
public class SlackClient implements Client {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String notify(String payload) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(payload, headers);

		return restTemplate.exchange("https://hooks.slack.com/services/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", HttpMethod.POST, entity, String.class).getBody();
	}

}
