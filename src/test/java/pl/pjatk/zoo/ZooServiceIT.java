package pl.pjatk.zoo;

import org.hibernate.type.TrueFalseType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ZooServiceIT {

    @Autowired
    private  ZooService zooService;

    @MockBean
    private ZooRepository zooRepository;

    @Test
    void shouldAddPrefixToName() {
        //GIVEN
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, List.of());
        //WHEN
        zooService.addPrefixToName(zoo, "PREFIX__");
        //THEN
        assertThat(zoo.getName()).isEqualTo("PREFIX__jakies zoo");
    }
    @Test
    void shouldNotAddPrefixToName() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "gdansk", true, List.of());
        //WHEN
        zooService.addPrefixToName(zoo, "PREFIX__");
        //THEN
        assertThat(zoo.getName()).isNull();
    }
    @Test
    void shouldChangeZooName() {
        //GIVEN
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, List.of());
        //WHEN
        zooService.changeZooName(zoo, "new_name");
        //THEN
        assertThat(zoo.getName()).isEqualTo("new_name");
    }
    @Test
    void shouldNotChangeZooName() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "gdansk", true, List.of());
        //WHEN
        zooService.changeZooName(zoo, "new_name");
        //THEN
        assertThat(zoo.getName()).isNull();
    }
    @Test
    void shouldAddAnimalToZoo() {
        //GIVEN
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, new ArrayList<>());
        Animal animal = new Animal(1, "ssak", Diet.MEAT, Type.LAND, Health.HEALTHY, false);
        //WHEN
        zooService.addAnimalToZoo(zoo, animal);
        //THEN
        assertThat(zoo.getAnimalList()).isNotNull().hasSize(1);
    }
    @Test
    void shouldNotAddAnimalToZoo() {
        //GIVEN
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, null);
        Animal animal = new Animal(1, "ssak", Diet.MEAT, Type.LAND, Health.HEALTHY, false);
        //WHEN
        zooService.addAnimalToZoo(zoo, animal);
        //THEN
        assertThat(zoo.getAnimalList()).isNull();
    }
    @Test
    void shouldAnimalListBeEmpty() {
        //GIVEN
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, new ArrayList<>());
        //WHEN
        zooService.isAnimalListEmpty(zoo);
        //THEN
        assertThat(zoo.getAnimalList()).isEmpty();
    }
    @Test
    void shouldAnimalListNotBeEmpty() {
        //GIVEN
        Animal animal = new Animal(1, "ssak", Diet.MEAT, Type.LAND, Health.HEALTHY, false);
        Zoo zoo = new Zoo(null, "jakies zoo", "gdansk", true, List.of(animal));
        //WHEN
        zooService.isAnimalListEmpty(zoo);
        //THEN
        assertThat(zoo.getAnimalList()).isNotEmpty();
    }
    @Test
    void shouldChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, "gdansk", true, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "new_location");
        //THEN
        assertThat(zoo.getLocation()).isNotNull();
    }
    @Test
    void shouldNotChangeZooLocation() {
        //GIVEN
        Zoo zoo = new Zoo(null, null, null, true, List.of());
        //WHEN
        zooService.changeZooLocation(zoo, "new_location");
        //THEN
        assertThat(zoo.getLocation()).isNull();
    }
    @Test
    void shouldChangeDiet() {
        //GIVEN
        Animal animal = new Animal(null, null, Diet.MEAT, null, null, null);
        //WHEN
        zooService.changeDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isEqualTo(Diet.MIXED);
    }
    @Test
    void shouldNotChangeAnimalDiet() {
        //GIVEN
        Animal animal = new Animal(null, null, null, null, null, null);
        //WHEN
        zooService.changeDiet(animal, Diet.MIXED);
        //THEN
        assertThat(animal.getDiet()).isNull();
    }

    @Test
    void shouldFindById() {
        Mockito.when(zooRepository.findById(any()))
                .thenReturn(Optional.of(new Zoo()));

        Zoo byId = zooService.findById(1);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldNotFindById() {
        Mockito.when(zooRepository.findById(any()))
                .thenReturn(Optional.empty());

        Zoo byId = zooService.findById(1);

        assertThat(byId).isNull();
    }

    @Test
    void shouldGetAllZoo() {
        List<Zoo> zooList = List.of(new Zoo(), new Zoo());
        Mockito.when(zooRepository.findAll())
                .thenReturn(zooList);

        List<Zoo> all = zooService.getAllZoos();

        assertThat(all).hasSize(zooList.size());
    }

    @Test
    void shouldGetEmptyZooList() {
        List<Zoo> zooList = List.of();
        Mockito.when(zooRepository.findAll())
                .thenReturn(zooList);

        List<Zoo> all = zooService.getAllZoos();

        assertThat(all).isEmpty();
    }

    @Test
    void shouldExistsById() {
        Mockito.when(zooRepository.existsById(any()))
                .thenReturn(true);

        boolean exists = zooService.zooExistById(1);

        assertThat(exists).isTrue();
    }

    @Test
    void shouldNotExistsById() {
        Mockito.when(zooRepository.existsById(any()))
                .thenReturn(false);

        boolean exists = zooService.zooExistById(1);

        assertThat(exists).isFalse();
    }

    @Test
    void shouldDeleteZooById() {
        zooService.deleteZooById(1);

        Mockito.verify(zooRepository).deleteById(any());
    }
}
