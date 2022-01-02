package htw.berlin.webtech.TogetherFit.m2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> findAll() {
        List<ExerciseEntity> exercises = exerciseRepository.findAll();
        return exercises.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Exercise findById(Long id) {
        var exerciseEntity = exerciseRepository.findById(id);
        return exerciseEntity.map(this::transformEntity).orElse(null);
    }

    public Exercise create(ExerciseManipulationRequest request) {
        var exerciseEntity = new ExerciseEntity(request.getName(),
                request.getCategory(),
                request.getDifficulty(),
                request.getGear());
        exerciseEntity = exerciseRepository.save(exerciseEntity);
        return transformEntity(exerciseEntity);
    }

    public Exercise update (Long id, ExerciseManipulationRequest request) {
        var exerciseEntityOptional = exerciseRepository.findById(id);
        if(exerciseEntityOptional.isEmpty()){
            return null;
        }

        var exerciseEntity = exerciseEntityOptional.get();
        exerciseEntity.setName(request.getName());

        return transformEntity(exerciseEntity);
    }

    public boolean deleteById(Long id){
        if(!exerciseRepository.existsById(id)) {
            return false;
        }
        exerciseRepository.deleteById(id);
        return true;
    }

    private Exercise transformEntity(ExerciseEntity exerciseEntity) {
        return new Exercise(
                exerciseEntity.getId(),
                exerciseEntity.getName(),
                exerciseEntity.getCategory(),
                exerciseEntity.getDifficulty(),
                exerciseEntity.getGear()
        );
    }





}
