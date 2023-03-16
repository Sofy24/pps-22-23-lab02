package u02

object GCD extends App:
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a,b) match
    case (a,b) if (a % b == 0) => b
    case (a,b) if (a > b) => gcd(b, a % b)
    case (a,b) if (a <= b) => gcd(a, a % b)

  println(gcd(14,7))
  println(gcd(12,8))
  println(gcd(2, 2))
  println(gcd(2, 4))