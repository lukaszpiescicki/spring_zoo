package info.practice.springzoo.application.api;

import info.practice.springzoo.domain.animal.AnimalDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnimalListingTest {

    @Autowired
    AnimalRestController animalRestController;

    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    void should_return_empty_list() {

        //when
        ResponseEntity<AnimalListResponse> animalListResponse = animalRestController.list();


        //then
        assertEquals(HttpStatus.OK, animalListResponse.getStatusCode());
        assertNotNull(animalListResponse.getBody());
        assertNotNull(animalListResponse.getBody().getAnimals());
        assertEquals(animalListResponse.getBody().getAnimals().size(), 0);


    }

    @Test
    void shouldReturnAnimalsWhenCallingEndpoint(){

        //when
        ResponseEntity<AnimalListResponse> response = testRestTemplate
                .withBasicAuth("user1", "user1Pass")
                .getForEntity("/zoo/animals", AnimalListResponse.class);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}