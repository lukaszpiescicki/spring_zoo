package info.practice.springzoo.domain.animal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalDomainServiceImpl implements AnimalDomainService{



    @Override
    public List<AnimalDto> getAllAnimals() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void addAnimall(AnimalDto animalDto) {
        throw new RuntimeException("Not implemented");

    }
}
