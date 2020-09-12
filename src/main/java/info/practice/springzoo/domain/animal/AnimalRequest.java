package info.practice.springzoo.domain.animal;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Validated
public class AnimalRequest {

    String id;

    @NotBlank
    @NotNull
    String name;

    @NotBlank
    @NotNull
    String species;

    Instant dateOfBirth;

    @Min(value = 0)
    @Max(value = 10000)
    Integer weightKilos;
    boolean dangerous;

    public AnimalDto toAnimalDto(){
        return AnimalDto(null, name,species,dateOfBirth,weightKilos,dangerous);
    }




}
