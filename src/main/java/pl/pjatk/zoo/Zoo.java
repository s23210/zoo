package pl.pjatk.zoo;

import java.util.List;

public class Zoo {
    private Integer id;
    private String name;
    private String location;
    private Boolean isOpen;
    private List<Animal> animalList;

    public Zoo(Integer id, String name, String location, Boolean isOpen, List<Animal> animalList) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.isOpen = isOpen;
        this.animalList = animalList;
    }

    public Zoo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", isOpen=" + isOpen +
                ", animalList=" + animalList +
                '}';
    }
}
