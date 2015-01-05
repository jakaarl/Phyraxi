package phyraxi.domain

import scala.beans.BeanProperty
import scala.beans.BooleanBeanProperty

case class Planet(
    @BeanProperty val name: String,
    @BeanProperty val distance: Int,
    @BeanProperty val planetType: PlanetType,
    @BeanProperty val mass: Int,
    @BeanProperty val radius: Int,
    @BeanProperty val density: Int,
    @BeanProperty val gravity: Int,
    @BooleanBeanProperty val tidallyLocked: Boolean) extends Satellite {

}