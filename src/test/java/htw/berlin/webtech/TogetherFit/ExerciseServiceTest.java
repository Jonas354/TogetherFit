package htw.berlin.webtech.TogetherFit;

import htw.berlin.webtech.TogetherFit.m2.Exercise;
import htw.berlin.webtech.TogetherFit.m2.ExerciseEntity;
import htw.berlin.webtech.TogetherFit.m2.ExerciseRepository;
import htw.berlin.webtech.TogetherFit.m2.ExerciseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
@SpringBootTest
public class ExerciseServiceTest {
    @Autowired
    private ExerciseService service;

    @MockBean
    private ExerciseRepository repository;
/*
    @Test
    @DisplayName("should find exersice by id")
    void testGet() {
        var ex1 = new ExerciseEntity("Jumping Jacks");
        ex1.setId(99L);
        doReturn(Optional.of(ex1)).when(repository).findById(99L);
       // doReturn(Optional.of(ex1)).when(repository).findById(100L);

        Exercise actualExercise = service.findById(99L);

        assertEquals(actualExercise.getName(),"Jumping Jacks");
    }
*/

}
