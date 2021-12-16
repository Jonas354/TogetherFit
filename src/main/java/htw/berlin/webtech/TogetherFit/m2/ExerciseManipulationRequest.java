package htw.berlin.webtech.TogetherFit.m2;

public class ExerciseManipulationRequest {

    private String name;

    public ExerciseManipulationRequest(String name) {
        this.name = name;
    }

    public ExerciseManipulationRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
