package phyraxi.domain

import java.lang.Double
import scala.beans.BeanProperty

case class Star(
    @BeanProperty val name: String,
    @BeanProperty val population: StarPopulation,
    @BeanProperty val spectralType: SpectralType,
    @BeanProperty val spectralNumber: Int,
    @BeanProperty val luminosityClass: LuminosityClass,
    @BeanProperty val mass: Double,
    @BeanProperty val brightness: Double,
    @BeanProperty val effectiveTemperature: Int) {
  
  override def toString(): String = {
    name + " [ " + spectralType.toString() + spectralNumber + luminosityClass.toString() + " ]"
  }

}