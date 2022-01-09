package htw.berlin.webtech.TogetherFit.m2;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ExerciseManipulationRequest {

    @Size(min = 3, message = "Please choose an exercise with at least 3 letters.")
    private String name;

    @Pattern(
            regexp = "upper body|arms|core|legs",
            message = "Please provide 'upper body', 'arms', 'core' or 'legs' for category."
    )
    private String category;

    @Pattern(
            regexp = "low|medium|hard",
            message = "Please provide 'low', 'medium' or 'hard' for difficulty."
    )
    private String difficulty;

    @NotNull(message = "Gear must be true or false.")
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
