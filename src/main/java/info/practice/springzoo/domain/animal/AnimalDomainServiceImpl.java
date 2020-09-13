package info.practice.springzoo.domain.animal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalDomainServiceImpl implements AnimalDomainService{

    private final AnimalRepository animalRepository;

    public AnimalDomainServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        return animalRepository.findAll().stream()
                .map(AnimalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void addAnimall(AnimalDto animalDto) {
        throw new RuntimeException("Not implemented");

    }
}
