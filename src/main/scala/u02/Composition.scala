package u02

object Composition extends App:
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  println(compose(_ - 1, _ * 2)(5))

  def compose2[X, Y, Z] (f: Y => Z, g: X => Y): X => Z =
    (x: X) => f(g(x))
  val f: Int => Int = _ - 1
  val g: Int => Int = _ * 2
  println(compose(f, g)(5))
