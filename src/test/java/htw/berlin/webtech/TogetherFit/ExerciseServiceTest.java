package htw.berlin.webtech.TogetherFit;


import htw.berlin.webtech.TogetherFit.m2.Exercise;
import htw.berlin.webtech.TogetherFit.m2.ExerciseEntity;
import htw.berlin.webtech.TogetherFit.m2.ExerciseRepository;
import htw.berlin.webtech.TogetherFit.m2.ExerciseService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest implements WithAssertions {

    @Mock
    private ExerciseRepository repository;

    @InjectMocks
    private ExerciseService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void returnTrueForSuccessfulDeletion() {
        Long givenId = 123L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if delete was not successful (exercise dosen't exists)")
    void returnFalseForNotSuccessfulDeletion() {
        Long givenId = 123L;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }
}
