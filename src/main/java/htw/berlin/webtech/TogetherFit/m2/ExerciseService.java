package htw.berlin.webtech.TogetherFit.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository repo;

    public Exercise save(Exercise exercise) {
        return repo.save(exercise);
    }

    public Exercise get(Long id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }
}