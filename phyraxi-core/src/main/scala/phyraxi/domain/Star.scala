package phyraxi.domain

import java.lang.Double

case class Star(
    val name: String,
    val population: StarPopulation,
    val spectralType: SpectralType,
    val spectralNumber: Int,
    val luminosityClass: LuminosityClass,
    val mass: Double,
    val brightness: Double,
    val effectiveTemperature: Int) {
  
  override def toString(): String = {
    name + " [ " + spectralType.toString() + spectralNumber + luminosityClass.toString() + " ]"
  }

}