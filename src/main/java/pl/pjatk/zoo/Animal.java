package pl.pjatk.zoo;

public class Animal {
    private Integer id;
    private String specimen;
    private Diet diet;
    private Type type;
    private Health health;
    private Boolean hunger;

    public Animal() {
    }

    public Animal(Integer id, String specimen, Diet diet, Type type, Health health, Boolean hunger) {
        this.id = id;
        this.specimen = specimen;
        this.diet = diet;
        this.type = type;
        this.health = health;
        this.hunger = hunger;
    }

    public Integer getId() {
        return id;
    }

    public String getSpecimen() {
        return specimen;
    }

    public Diet getDiet() {
        return diet;
    }

    public Type getType() {
        return type;
    }

    public Health getHealth() {
        return health;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Boolean getHunger() {
        return hunger;
    }

    public void setHunger(Boolean hunger) {
        this.hunger = hunger;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", specimen='" + specimen + '\'' +
                ", diet=" + diet +
                ", type=" + type +
                ", health=" + health +
                ", hunger=" + hunger +
                '}';
    }
}

