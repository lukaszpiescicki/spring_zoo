package info.practice.springzoo.domain.animal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class AnimalDomainServiceImplTest {

    //to będę testował
    private AnimalDomainService animalDomainService;

    //to jest zaleznosc mojej klasy, ktora bede testowal
    private AnimalRepository animalRepositoryMock;

    @BeforeEach
    void setUp() {
        animalRepositoryMock = Mockito.mock(AnimalRepository.class); //stworzylem mocka
        animalDomainService = new AnimalDomainServiceImpl(animalRepositoryMock); // wstrzyknalem mocka do testowanego obiektu
    }

    @Test
    void getAllAnimals() {

        //given
        Mockito.when(animalRepositoryMock.findAll()).thenReturn(Collections.emptyList());
        //when
        List<AnimalDto> allAnimals = animalDomainService.getAllAnimals();

        //then
        assertEquals(0, allAnimals.size());

    }

    @Test
    void shouldReturnAnimalOnList() {

        //given
        final AnimalEntity animalEntity = AnimalEntity.builder()
                .id(UUID.randomUUID())
                .dangerous(true)
                .name("burek")
                .dateOfBirth(Instant.parse("2007-12-03T10:15:30.00Z"))
                .species("Lion")
                .weightKilos(200)
                .build();
        Mockito.when(animalRepositoryMock.findAll()).thenReturn(List.of(animalEntity));
        //when
        List<AnimalDto> allAnimals = animalDomainService.getAllAnimals();

        //then
        assertEquals(1, allAnimals.size());

    }
}