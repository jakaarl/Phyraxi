package phyraxi.domain

import scala.beans.BeanProperty

case class AsteroidBelt(
    @BeanProperty val name: String,
    @BeanProperty val distance: Int) extends Satellite {

}