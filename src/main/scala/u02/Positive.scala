package u02

object Positive extends App:
  val positive = (x: Int) => x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  val positive2: Int => String =
    (x: Int) => x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  val positive3: Int => String = x => x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  def positive4(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println(positive4(-4))
  println(positive4(-4))
  println(positive4(-4))
  println(positive4(-4))
