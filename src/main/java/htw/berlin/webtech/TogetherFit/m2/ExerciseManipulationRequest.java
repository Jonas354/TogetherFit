package htw.berlin.webtech.TogetherFit.m2;

import javax.validation.constraints.Size;

public class ExerciseManipulationRequest {

    //@Size(min = 4, message = "Please choose an exercise with at least 4 letters")
    private String name;
    private String category;
    private String difficulty;
    private Boolean gear;

    public ExerciseManipulationRequest(String name, String category, String difficulty, Boolean gear) {
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.gear = gear;
    }

    public ExerciseManipulationRequest() {}

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
