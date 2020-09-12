package info.practice.springzoo.application.api;

import info.practice.springzoo.application.AnimalService;
import info.practice.springzoo.domain.animal.AnimalDto;
import info.practice.springzoo.domain.animal.AnimalRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AnimalRestController {
    private final AnimalService animalService;

    public AnimalRestController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public AnimalListResponse list(){
        return new AnimalListResponse(animalService.getAllAnimals());
    }

    @PostMapping("/animals")
    public void add(@Valid @RequestBody AnimalRequest animalRequest){
        animalService.addAnimal(animalRequest.toAnimalDto());
    }

}
