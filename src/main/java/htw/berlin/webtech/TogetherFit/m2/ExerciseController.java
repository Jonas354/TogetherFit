package htw.berlin.webtech.TogetherFit.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(path = "/exercises")
    public ResponseEntity<List<Exercise>> fetchExercises(){
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/exercises/{id}")
    public ResponseEntity<Exercise> fetchExerciseById(@PathVariable Long id) {
        var exercise = exerciseService.findById(id);
        return exercise != null? ResponseEntity.ok(exercise) : ResponseEntity.notFound().build();
    }

   @PostMapping(path = "/exercises")
    public ResponseEntity<Void> createExercise(@RequestBody ExerciseManipulationRequest request) throws URISyntaxException {
        var exercise = exerciseService.create(request);
        URI uri = new URI("/exercises/" + exercise.getId());
        return ResponseEntity.created(uri).build();
   }

   @PutMapping(path = "/exercises/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody ExerciseManipulationRequest request) {
        var exercise = exerciseService.update(id, request);
        return exercise != null ? ResponseEntity.ok(exercise) : ResponseEntity.notFound().build();
   }

   @DeleteMapping(path = "/exercises/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        boolean successful = exerciseService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
   }
}
