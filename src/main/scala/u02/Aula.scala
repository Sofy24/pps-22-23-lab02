package u02

object Aula extends App:
  enum List:
    case Cons(head: Int, tail: List)
    case Nil

  import List.*

  def size(list:List):Int = list match
    case Nil => 0
    case Cons(h, t) => 1 + size(t)

  println(size(Cons(10, Cons(20, Nil))))
