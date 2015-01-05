package phyraxi.server.rest.data;

import java.util.List;

import phyraxi.domain.Coordinates;
import phyraxi.domain.Star;


/**
 * A data transfer object for star map.
 * 
 * @author Jani Kaarela (@gmail.com)
 */
public class StarMap {

	private final Coordinates dimensions;
	private final List<StarInfo> stars;

	public StarMap(Coordinates dimensions, List<StarInfo> stars) {
		this.dimensions = dimensions;
		this.stars = stars;
	}

	public Coordinates getDimensions() {
		return dimensions;
	}
	
	public List<StarInfo> getStars() {
		return stars;
	}

	public static class StarInfo {

		final Star star;
		final String type;
		final Coordinates coordinates;

		public StarInfo(Star star, Coordinates coordinates) {
			this.star = star;
			this.coordinates = coordinates;
			this.type = star.spectralType().toString() + star.spectralNumber() + star.luminosityClass();
		}

		public String getName() {
			return star.name();
		}

		public String getType() {
			return type;
		}

		public Coordinates getCoordinates() {
			return coordinates;
		}

	}

}
