package info.practice.springzoo.application.api;

import info.practice.springzoo.domain.animal.AnimalDto;
import lombok.Data;

import java.util.List;

@Data

public class AnimalListResponse {

    List<AnimalDto> animals;

    public static AnimalListResponse from(List<AnimalDto> animals){
        return new AnimalListResponse(animals);
    }

    public AnimalListResponse(List<AnimalDto> animals) {
        this.animals = animals;
    }
}
