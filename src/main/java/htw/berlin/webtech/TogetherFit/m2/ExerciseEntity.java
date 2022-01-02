package htw.berlin.webtech.TogetherFit.m2;

import javax.persistence.*;

@Entity(name= "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "gear", nullable = false)
    private Boolean gear;

    // just for Hibernate
    protected  ExerciseEntity() {}

    public ExerciseEntity(String name, String category, String difficulty, Boolean gear) {
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.gear = gear;
    }

    public Long getId() {
        return id;
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
}
