package phyraxi.domain

import org.scalatest.FlatSpec

class StarSpec extends FlatSpec {
  
  "A Star" should "be instantiable" in {
    var star = Star(
        "A test star",
        StarPopulation.CORE_POPULATION_I,
        SpectralType.A,
        0,
        LuminosityClass.BRIGHT_GIANT,
        50,
        25000,
        30000)
    assert(star != null)
  }
  
}