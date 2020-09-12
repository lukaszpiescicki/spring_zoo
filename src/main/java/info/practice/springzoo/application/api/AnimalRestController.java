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

    @GetMapping("zoo")
    public AnimalListResponse list(){
        return new AnimalListResponse(animalService.getAllAnimals());
    }

    @PostMapping("zoo")
    public void add(@Valid @RequestBody AnimalDto animalDto){
        AnimalRequest animalRequest = new AnimalRequest();
        animalService.addAnimal(animalDto.convertFromRequest(animalRequest));
    }

}
