package info.practice.springzoo.domain.animal;

import lombok.Value;

import java.time.Instant;

@Value
public class AnimalDto {
    String id;
    String name;
    String species;
    Instant dateOfBirth;
    Integer weightKilos;
    boolean dangerous;

    public static AnimalDto fromAnimal(AnimalRequest animalRequest){
        return new AnimalDto(animalRequest.getId(), animalRequest.getSpecies(), animalRequest.getName(), animalRequest.getDateOfBirth(), animalRequest.getWeightKilos(), animalRequest.isDangerous());
    }

}
