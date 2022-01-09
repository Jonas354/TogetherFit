package htw.berlin.webtech.TogetherFit;

import htw.berlin.webtech.TogetherFit.m2.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExerciseService exerciseService;

    @Test
    @DisplayName("should return exercise from exercise service")
    void returnExercise() throws Exception {
        var exercises = List.of(
                new Exercise(123L, "Push", "arms", "low", true),
                new Exercise(124L, "Press", "arms", "low", false)
        );
        doReturn(exercises).when(exerciseService).findAll();

        mockMvc.perform(get("/exercises"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(123))
                .andExpect(jsonPath("$[0].name").value("Push"))
                .andExpect(jsonPath("$[0].category").value("arms"))
                .andExpect(jsonPath("$[0].difficulty").value("low"))
                .andExpect(jsonPath("$[0].gear").value(true))
                .andExpect(jsonPath("$[1].id").value(124))
                .andExpect(jsonPath("$[1].name").value("Press"))
                .andExpect(jsonPath("$[1].category").value("arms"))
                .andExpect(jsonPath("$[1].difficulty").value("low"))
                .andExpect(jsonPath("$[1].gear").value(false));

    }

    @Test
    @DisplayName("return 404 if person not found")
    void shouldReturn404() throws Exception {
        doReturn(null).when(exerciseService).findById(anyLong());

        mockMvc.perform(get("/exercises/123"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 and location header when creating an exercise")
    void postExercise() throws Exception {
        String exerciseToCreate = "{\"name\": \"Push\", \"category\":\"arms\", \"difficulty\":\"low\", \"gear\": true}";
        var exercise = new Exercise(123L, null, null, null, true);

        doReturn(exercise).when(exerciseService).create(any());

        mockMvc.perform(
                post("/exercises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(exerciseToCreate)
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo("/exercises/" + exercise.getId())));
    }

    @Test
    @DisplayName("validation create exercise request")
    void validationExercise() throws Exception {
        String exerciseToCreate = "{\"name\": \"\", \"category\":\"arms\", \"difficulty\":\"low\", \"gear\": true}";

        mockMvc.perform(
                post("/exercises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(exerciseToCreate)
                )
                .andExpect(status().isBadRequest());
    }
}
