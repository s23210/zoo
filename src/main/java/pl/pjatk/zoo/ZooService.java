package pl.pjatk.zoo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Zoo findById(Integer id) {
        Optional<Zoo> byId = zooRepository.findById(id);

        return byId.orElseThrow(RuntimeException::new);
    }

    public void addAnimalToZoo(Zoo zoo, Animal animal) {
        if (zoo.getAnimalList() != null) {
            zoo.getAnimalList().add(animal);
        }
    }

    public boolean isAnimalListEmpty(Zoo zoo) {
        if (zoo.getAnimalList().size() > 0) {
            return true;
        } else return false;
    }

    public void changeZooLocation(Zoo zoo, String location) {
        if (zoo.getLocation() != null) {
            zoo.setLocation(location);
        }
    }

    public void changeZooName(Zoo zoo, String name) {
        if (zoo.getName() != null) {
            zoo.setName(name);
        }
    }

    public void addPrefixToName(Zoo zoo, String prefix) {
        if (zoo.getName() != null) {
            zoo.setName(prefix + zoo.getName());
        }
    }

    public void changeDiet(Animal animal, Diet diet) {
        if (animal.getDiet() != null) {
            animal.setDiet(diet);
        }
    }
}


