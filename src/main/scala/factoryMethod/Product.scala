package factoryMethod

trait Product {
  def use
}

trait Factory {
  def create(owner: String): Product = {
    val p = createProduct(owner)
    registerProduct(p)
    p
  }
  protected def createProduct(owner: String): Product
  protected def registerProduct(product: Product)
}

