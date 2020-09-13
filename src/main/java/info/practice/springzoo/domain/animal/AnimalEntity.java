package info.practice.springzoo.domain.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalEntity {

    @Id
    @GeneratedValue
    UUID id;

    String name;
    String species;
    Instant dateOfBirth;
    Integer weightKilos;
    boolean dangerous;



//    public static AnimalEntity fromDto(AnimalDto animalDto){
//        return AnimalEntity.builder()
//                .name
//    }
}

