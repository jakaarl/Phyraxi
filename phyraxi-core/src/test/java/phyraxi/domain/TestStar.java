package phyraxi.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestStar {
	
	@Test
	public void shouldInstantiateStar() {
		Star star = new Star(
				"Test star", StarPopulation.CORE_POPULATION_I,
				SpectralType.A, 0, LuminosityClass.MAIN_SEQUENCE, 5.0, 200.0, 28000);
		assertNotNull(star);
	}

}
