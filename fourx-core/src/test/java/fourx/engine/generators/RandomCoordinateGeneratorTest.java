package fourx.engine.generators;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fourx.domain.Coordinates;

/**
 * Tests for {@link RandomCoordinateGenerator}.
 * 
 * @author Jani Kaarela
 */
public class RandomCoordinateGeneratorTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnGalaxySizeLessThanOne() {
		CoordinateGenerator generator = new RandomCoordinateGenerator();
		generator.generateStarSystemCoordinates(0);
	}

	@Test
	public void shouldGenerateCorrectNumberOfCoordinates() {
		int galaxySize = 10;
		CoordinateGenerator generator = new RandomCoordinateGenerator();
		List<Coordinates> coordinates = generator.generateStarSystemCoordinates(galaxySize);
		assertEquals(galaxySize, coordinates.size());
		for (Coordinates coords : coordinates) {
			System.out.println(coords);
		}
	}

}