package factoryMethod

import factoryMethod.framework._
import factoryMethod.idcard._

object Main {
  def main(args: Array[String]) {
    val factory: Factory = new IDCardFactory
    val card1 = factory.create("Alice")
    val card2 = factory.create("Bob")
    val card3 = factory.create("Cris")
    card1 use;
    card2 use;
    card3 use

  }
}

