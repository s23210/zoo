package pl.pjatk.zoo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooService {

    private final ZooRepository zooRepository;

    public ZooService(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public Zoo getExampleZoo() {
        Animal dog = new Animal(null, "mammal", Diet.MEAT, Type.LAND, Health.HEALTHY, false);
        List<Animal> animals = List.of(dog);
        Zoo zoo = new Zoo(null, "Gdanskie zoo", "Gdansk", true, animals);
        zooRepository.save(zoo);
        return zoo;
    }

    public Zoo getEmptyZoo() {
        return new Zoo(1, "Gdanskie zoo", "Gdansk", true, null);
    }

    public Zoo getEmptyZooForName(String name) {
        return new Zoo(1, name, "Gdansk", true, null);
    }

    public List<Zoo> getAllZoos() {
        List<Zoo> allByIdGreaterThan = zooRepository.findAllByIdGreaterThan(5);
        return allByIdGreaterThan;
    }
}


