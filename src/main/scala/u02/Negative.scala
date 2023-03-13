package u02

object Negative extends App:
  val neg: (String => Boolean) => (String => Boolean) =
    y => (f => !y(f))

  def neg2: (String => Boolean) => String => Boolean =
    y => (f => !y(f))

  val empty: String => Boolean = _ == ""
  val notEmpty = neg2(empty)

  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))
