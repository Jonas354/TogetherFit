package htw.berlin.webtech.TogetherFit;

import htw.berlin.webtech.TogetherFit.m2.Exercise;
import htw.berlin.webtech.TogetherFit.m2.ExerciseController;
import htw.berlin.webtech.TogetherFit.m2.ExerciseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExerciseController.class)
public class ExerciseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExerciseService exerciseService;

    @Test
    public void testGetRoute() throws Exception {
        Exercise ex1 = new Exercise("Plank");

        ex1.setId(98L);
        when(exerciseService.get(98L)).thenReturn(ex1);

        String expected = "{\"id\":98,\"name\":\"Plank\"}";

        this.mockMvc.perform(get("/exercise/98"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

}
