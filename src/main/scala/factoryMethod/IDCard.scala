package factoryMethod

import scala.collection.mutable

case class IDCard(val owner: String) extends Product {
  println(owner + "のカードを作ります")
  def use = println(owner + "のカードを使います。")
}

object IDCardFactory extends Factory {
  val owners = mutable.LinkedList[Product]()
  protected def createProduct(owner: String) = IDCard(owner)
  protected def registerProduct(product: Product) = owners :+ product
}

object Main {
  def main(args: Array[String]) {
    val card1 = IDCardFactory.create("Alice")
    val card2 = IDCardFactory.create("Bob")
    val card3 = IDCardFactory.create("Cris")
    card1 use;
    card2 use;
    card3 use;
  }
}