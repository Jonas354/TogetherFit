package htw.berlin.webtech.TogetherFit;

import htw.berlin.webtech.TogetherFit.m2.Exercise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExerciseTest {

	@Test
	void testToString() {

		String name = "Bizeps Curls";

		Exercise exercise = new Exercise(name);
		exercise.setId(10L);

		String expected = "Exercise{id=10, name=Bizeps Curls}";

		String actual = exercise.toString();

		assertEquals(expected, actual);
	}
}
