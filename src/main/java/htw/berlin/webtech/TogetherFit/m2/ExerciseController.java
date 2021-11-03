package htw.berlin.webtech.TogetherFit.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExerciseController {

    @Autowired
    ExerciseService service;

    @PostMapping("/exercise")
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return service.save(exercise);
    }

    @GetMapping("/exercise{id}")
    public Exercise getExercise(@PathVariable String id) {
        Long exerciseId = Long.parseLong(id);
        return service.get(exerciseId);
    }
}
