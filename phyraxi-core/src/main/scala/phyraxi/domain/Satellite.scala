package phyraxi.domain;

import scala.beans.BeanProperty

/**
 * A natural satellite orbiting a host star or planet.
 * 
 * @author jakaarl
 */
abstract class Satellite {
    val name: String
    /**
     * Distance from the planet's host star or planet. For satellites orbiting
     * stars, distance is in 1/100 astronomical units, while for satellites
     * orbiting planets distance is in host planet radiuses.
     */
    val distance: Int
}