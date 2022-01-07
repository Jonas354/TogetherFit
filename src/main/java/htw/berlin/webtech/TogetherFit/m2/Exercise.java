package htw.berlin.webtech.TogetherFit.m2;

public class Exercise {

    private Long id;
    private String name;
    private String category;
    private String difficulty;
    private Boolean gear;

    public Exercise(Long id, String name, String category, String difficulty, Boolean gear) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.gear = gear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getGear() {
        return gear;
    }

    public void setGear(Boolean gear) {
        this.gear = gear;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name=" + name +
                ", category=" + category +
                ", difficulty=" + difficulty +
                ", gear=" + gear +
                "}";
    }

}
