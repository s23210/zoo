package pl.pjatk.zoo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {
    @GetMapping("/example")
    public ResponseEntity<Zoo> getExampleZoo() {
        Animal dog = new Animal(1, "mammal", Diet.MEAT, Type.LAND, Health.HEALTHY, false);
        List<Animal> animals = List.of(dog);
        Zoo zoo = new Zoo(1, "Gdanskie zoo", "Gdansk", true, animals);
        return ResponseEntity.ok(zoo);
    }

    @GetMapping("/empty")
    public ResponseEntity<Zoo> getEmptyZoo() {
        Zoo zoo = new Zoo(1, "Gdanskie zoo", "Gdansk", true, null);
        return ResponseEntity.ok(zoo);
    }
}
