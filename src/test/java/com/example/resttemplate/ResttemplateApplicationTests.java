package com.example.resttemplate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateApplicationTests {

	@Test
	public void consumerAPI() {
		RestTemplate template = new RestTemplate();
		//https://api.trello.com/1/boards/5612e4f91b25c15e873722b8?fields=all
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.trello.com")
				.path("1/boards/5612e4f91b25c15e873722b8")
				.queryParam("fields", "all")
				.build();
		ResponseEntity<Trello> entity = template.getForEntity(uri.toUriString(), Trello.class);
		System.out.println(entity.getBody().getName());

	}

}