package factoryMethod

import scala.collection.mutable

case class IDCard(val owner: String) extends Product {
  println(owner + "のカードを作ります")
  def use = println(owner + "のカードを使います。")
}

class IDCardFactory extends Factory {
  val owners = mutable.LinkedList[Product]()
  protected def createProduct(owner: String) = IDCard(owner)
  protected def registerProduct(product: Product) = owners :+ product
}

object Main {
  def main(args: Array[String]) {
    val factory = new IDCardFactory
    val card1 = factory.create("Alice")
    val card2 = factory.create("Bob")
    val card3 = factory.create("Cris")
    card1 use;
    card2 use;
    card3 use;
  }
}