package adapter

case class Banner(val string: String) {
  def showWithParen = println("(" + string + ")")
  def showWithAster = println("*" + string + "*")
}

trait Print {
  def printWeak
  def printStrong
}


/**
 * 継承によるパターン
 */
class PrintBanner_1(val s: String) extends Banner(s) with Print {
  def printWeak = showWithParen
  def printStrong = showWithAster
}

class PrintBanner_2(val s: String) extends Print {
  val banner = new Banner(s)
  def printWeak = banner showWithParen
  def printStrong = banner showWithAster
}

object Main {
  def main(args: Array[String]) {
    val p1 = new PrintBanner_1("Hello")
    p1 printWeak;
    p1 printStrong;

    val p2 = new PrintBanner_2("Good Morning")
    p2 printWeak;
    p2 printStrong
  }
}

