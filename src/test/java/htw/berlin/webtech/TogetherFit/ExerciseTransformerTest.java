package htw.berlin.webtech.TogetherFit;

import htw.berlin.webtech.TogetherFit.m2.ExerciseEntity;
import htw.berlin.webtech.TogetherFit.m2.ExerciseService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ExerciseTransformerTest implements WithAssertions {

    @Autowired
    private ExerciseService service;

    @Test
    @DisplayName("Should transform ExerciseEntity to Exercise")
    void transformEntity() {
        var exerciseEntity = Mockito.mock(ExerciseEntity.class);
        doReturn(123L).when(exerciseEntity).getId();
        doReturn("Push Up").when(exerciseEntity).getName();
        doReturn("Arms").when(exerciseEntity).getCategory();
        doReturn("Low").when(exerciseEntity).getDifficulty();
        doReturn(true).when(exerciseEntity).getGear();

        var result = service.transformEntity(exerciseEntity);

        assertThat(result.getId()).isEqualTo(123);
        assertThat(result.getName()).isEqualTo("Push Up");
        assertThat(result.getCategory()).isEqualTo("Arms");
        assertThat(result.getDifficulty()).isEqualTo("Low");
        assertThat(result.getGear()).isEqualTo(true);
    }

}
