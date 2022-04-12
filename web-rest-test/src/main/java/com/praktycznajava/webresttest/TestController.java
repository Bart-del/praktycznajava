package com.praktycznajava.webresttest;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    private final static Logger logger = Logger.getLogger(TestController.class);

    @GetMapping("/slow-posts")
    public List<Post> getAllPosts() throws InterruptedException {
        Thread.sleep(2000);
        return Arrays.asList(
                new Post("post1", "andrzej"),
                new Post("post2", "marek"),
                new Post("post3", "jacek"));
    }

    @GetMapping("/posts-blocking")
    public List<Post> getPostsBlocking() {
        logger.info("Starting BLOCKING Controller!");
        final String uri = "http://localhost:8080/slow-posts";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Post>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Post>>(){});

        List<Post> result = response.getBody();
        result.forEach(post -> logger.info(post.toString()));
        logger.info("Exiting BLOCKING Controller!");
        return result;
    }

    @GetMapping(value = "/posts-non-blocking",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Post> getPostsNonBlocking() {
        logger.info("Starting NON-BLOCKING Controller!");
        Flux<Post> postFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080/slow-posts")
                .retrieve()
                .bodyToFlux(Post.class);

        postFlux.subscribe(post -> logger.info(post.toString()));
        logger.info("Exiting NON-BLOCKING Controller!");
        return postFlux;
    }
}

