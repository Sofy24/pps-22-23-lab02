package u02

object CurryingPart2b extends App:
  val p1: Int => Int => Int => Boolean = x => y => z => (x <= y) && y== z
  val p2: (x: Int, y: Int, z: Int) => Boolean = (x, y, z) => ((x <= y) && y == z)
  def p3(x:Int)(y:Int)(z:Int): Boolean = (x <= y) && y== z
  def p4(x: Int, y: Int, z: Int): Boolean = (x <= y) && y== z

  println(p1(1)(2)(4))
  println(p2(1,2,2))
  println(p3(1)(2)(2))
  println(p4(1,2,4))