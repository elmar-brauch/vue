package de.bsi.vue.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarControllerTest {

    @Test
    void readCars() {
        var client = WebTestClient.bindToController(CarController.class).build();
        client.get().uri("/car").exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody().jsonPath("$.CarMake").isEqualTo("Tesla");
    }
}