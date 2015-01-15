package iterator

import scala.collection.mutable.ListBuffer

trait Aggregate[+T] {
  def iterator: Iterator[T]
}

trait Iterator[+T] {
  def hasNext: Boolean
  def next: T
}

case class Book(val name: String)
case class Magazine(override val name: String, val month: Int) extends Book(name)

class BookShelf extends Aggregate[Book] {
  val books: ListBuffer[Book] = ListBuffer.empty
  var last = 0
  def getBookAt(index: Int) = books(index)
  def appendBook(book: Book) = {
    books +=  book
    last += 1
  }
  def getLength = last
  def iterator = new BookShelfIterator(this)
}

class BookShelfIterator(val bookShelf: BookShelf) extends Iterator[Book] {
  var index = 0
  def hasNext = {
    if (index < bookShelf.getLength)
      true
    else
      false
  }
  def next = {
    val book = bookShelf.getBookAt(index)
    index += 1
    book
  }
}

object Main {
  def main (args: Array[String]) {
    val bookShelf = new BookShelf
    bookShelf appendBook Book("Around the World in 80 Days")
    bookShelf appendBook Book("Bible")
    bookShelf appendBook Book("Cinderella")
    bookShelf appendBook Book("Daddy-Long-Legs")
    bookShelf appendBook Book("Edgar Allan Poe")
    bookShelf appendBook Magazine("Weekly JUMP", 12)
    val it = bookShelf.iterator
    while (it.hasNext) {
      val book = it.next
      println(book.name)
    }

    println("------Use Scala API ------")
    val itr = collection.Iterator(
      Book("Around the World in 80 Days"),
      Book("Bible"),
      Book("Cinderella"),
      Book("Daddy-Long-Legs"),
      Book("Edgar Allan Poe")
    )
    itr foreach(book => println(book.name))
  }
}