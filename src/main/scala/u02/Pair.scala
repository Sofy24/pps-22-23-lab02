package u02

object Pair extends App:
  //JAVA = case class Pair(fst:Int, snd: Int)
  case class Pair[A, B](fst: A, snd: B)

  //JAVA = <A, B> def reverse(p: Pair<A, B>) : Pair<A, B> = p match
  def reverse[A, B] (p: Pair[A, B] ) : Pair[B, A]  = p match
    case Pair(f, s) => Pair(s, f)

  println(reverse(Pair(20,10)))