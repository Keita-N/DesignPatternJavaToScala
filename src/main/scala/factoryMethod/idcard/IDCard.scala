package factoryMethod.idcard

import factoryMethod.framework.{Factory, Product}

import scala.collection.mutable

protected [idcard] case class IDCard(val id: Int, val owner: String) extends Product {
  println(owner + "のカード(id: " + id + ")を作ります")
  def use = println(owner + "のカードを使います。")
}

class IDCardFactory extends Factory {
  val owners = mutable.LinkedList()
  var id = 0
  protected def createProduct(owner: String) = new IDCard(createID, owner)
  protected def registerProduct(product: Product) = product match {
    case IDCard(id, owner) => owners :+ owner
  }

  /**
   * 通し番号を発行
   * @return
   */
  private def createID = {
    id += 1
    id
  }

  /**
   * 通し番号をリセット
   */
  def resetID = id = 0
}
