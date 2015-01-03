package templateMethod

trait Display {
  def open
  def print
  def close
  def display: Unit = {
    open
    for (i <- 0 until 5) print
    close
  }
}

class CharDisplay(val ch: Char) extends Display {
  def open = Console.print("<<")
  def print = Console.print(ch.toString)
  def close = println(">>")

}

class StringDisplay(val string: String) extends Display {
   val width = string.getBytes.length
  def open = printLine
  def print = println("|" + string + "|")
  def close = printLine

  private def printLine: Unit = {
    println("+" + "-" * width + "+")
  }
}

object Main {
  def main(args: Array[String]) {
    val d1: Display = new CharDisplay('H')
    val d2: Display = new StringDisplay("Hello, World.")
    val d3: Display = new StringDisplay("こんにちは")
    d1 display;
    d2 display;
    d3 display;
  }
}