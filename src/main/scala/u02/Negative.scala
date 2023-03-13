package u02

object Negative extends App:
  val neg: (String => Boolean) => (String => Boolean) =
    predicate => (str => !predicate(str))

  def neg2: (String => Boolean) => String => Boolean =
    predicate => (str => !predicate(str))

  val empty: String => Boolean = _ == ""
  val notEmpty = neg2(empty)

  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))

  def neg3[X] (value: X => Boolean) : (X => Boolean) =
    v => !value(v)

  val notEmpty2 = neg3(empty)

  println(notEmpty2("foo"))
  println(notEmpty2(""))
  println(notEmpty2("foo") && !notEmpty2(""))