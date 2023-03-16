package u02

object Lab02 extends App:
  //Task part 1, svolto da sola
  def hello() = println("Hello world!")
  hello()

  //Task part 2a, svolto da sola
  // es 3a
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

  println("\nEs 3a")
  println(positive4(-4)) //negative
  println(positive4(4)) //positive
  println(positive4(-4)) //negative
  println(positive4(4)) //positive

  //es 3b
  val neg: (String => Boolean) => (String => Boolean) =
    predicate => (str => !predicate(str))

  def neg2: (String => Boolean) => String => Boolean =
    predicate => (str => !predicate(str))

  val empty: String => Boolean = _ == ""
  val notEmpty = neg2(empty)

  println("\nEs 3b")
  println(notEmpty("foo")) //true
  println(notEmpty("")) //false
  println(notEmpty("foo") && !notEmpty("")) //true

  //es 3c

  def neg3[X] (value: X => Boolean) : (X => Boolean) =
    v => !value(v)

  val notEmpty2 = neg3(empty)

  println("\nEs 3c")
  println(notEmpty2("foo")) //true
  println(notEmpty2("")) //false
  println(notEmpty2("foo") && !notEmpty2("")) //true

  //Task part 2b, svolto da sola
  //es 4
  val p1: Int => Int => Int => Boolean = x => y => z => (x <= y) && y== z
  val p2: (x: Int, y: Int, z: Int) => Boolean = (x, y, z) => ((x <= y) && y == z)
  def p3(x:Int)(y:Int)(z:Int): Boolean = (x <= y) && y== z
  def p4(x: Int, y: Int, z: Int): Boolean = (x <= y) && y== z

  println("\nEs 4")
  println(p1(1)(2)(4)) //false
  println(p2(1,2,2)) //true
  println(p3(1)(2)(2)) //true
  println(p4(1,2,4)) //false

  //es 5
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println("\nEs 5")
  println(compose(_ - 1, _ * 2)(5)) //9
  println(compose(_ * 2, _ - 2)(5)) //6

  def compose2[X, Y, Z] (f: Y => Z, g: X => Y): X => Z =
    (x: X) => f(g(x))
  val f: Int => Int = _ - 1
  val g: Int => Int = _ * 2

  println(compose(f, g)(5)) //9
  println(compose(g, f)(2)) //2

  //Task part 3, svolto da sola
  //es 6
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a,b) match
    case (a,b) if (a % b == 0) => b
    case (a,b) if (a > b) => gcd(b, a % b)
    case (a,b) if (a <= b) => gcd(a, a % b)

  println("\nEs 6")
  println(gcd(14,7)) //7
  println(gcd(12,8)) //4
  println(gcd(2, 2)) //2
  println(gcd(2, 4)) //2

  //Task part 4, svolto da sola
  //es 7
  final val pi = java.lang.Math.PI
  val inRectangle = (x: Double, y: Double, px: Double, py: Double, b: Int, h: Int) => ((px <= x + b && px >= x) && (py <= y + h && py >= y))
  val inCircle = (x: Double, y: Double, px: Double, py: Double, r: Int) => ((px <= x + r && px >= -(x + r)) && (py <= y + r && py >= -(y + r)))
  val inSquare = (x: Double, y: Double, px: Double, py: Double, s: Int) => ((px <= x + s && px >= x) && (py <= y + s && py >= y))

  enum Shape:
    case Rectangle(basis: Int, height: Int, leftBottomAngle: (Double, Double))
    case Circle(radius: Int, center: (Double, Double))
    case Square(side: Int, leftBottomAngle: (Double, Double))

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(b, h, _) => (b * 2) + (h * 2)
      case Circle(r, _) => r * 2 * pi
      case Square(s, _) => s * 4



    def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
      case Rectangle(b, h, (x,y)) => inRectangle(x, y, point._1, point._2, b, h)
      case Circle(r, (x, y)) => inCircle(x, y, point._1, point._2, r)
      case Square(s, (x, y)) => inSquare(x, y, point._1, point._2, s)
      case _ => false

  import Shape.*

  println("\nEs 7")
  println(perimeter(Square(4, (0.0, 1.0)))) //16.0
  println(perimeter(Circle(4, (0,1)))) //25.132741228718345
  println(perimeter(Rectangle(4, 2, (0,1)))) //12.0

  println(contains(Square(4, (0.0, 0.0)), (2.0, 2.0))) //true
  println(contains(Square(4, (0.0, 0.0)), (5.0, 2.0))) //false
  println(contains(Circle(4, (0,1)), (3.0, 3.0))) //true
  println(contains(Circle(4, (0,1)), (3.0, 6.0))) //false
  println(contains(Rectangle(4, 2, (0,1)), (1.0, 1.0))) //true
  println(contains(Rectangle(4, 2, (0,1)), (1.0, 4.0))) //false

  //Task part 5, svolto da sola
  //es 8
  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()

    def filter[A] (opt: Option[A])(predicate: A => Boolean): Option[A] = opt match
      case Some(a) if predicate(a) => Some(a)
      case _ => None()

    def map[A] (opt:Option[A])(predicate: A => Boolean): Option[Boolean] = opt match
      case Some(a) => Option.Some(predicate(a))
      case _ => Option.None()

    def fold[A] (opt:Option[A])(default: Int)(f: A => Int): Int = opt match
      case Some(a) => f(a)
      case None() => default
  import Option.*

  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  println("\nEs 8")
  println(s1) // Some(1)
  println(orElse(s1, 0)) //1
  println(orElse(s3, 0)) //0
  println(flatMap(s1)(i => Some(i + 1))) // Some(2)
  println(flatMap(s1)(i => flatMap(s2)(j => Some(i + j)))) // Some(3)
  println(flatMap(s1)(i => flatMap(s3)(j => Some(i + j)))) // None
  println(fold(Some(5))(1)(_ + 1)) // 6
  println(fold(None[Int]())(1)(_ + 1)) // 1
  println(filter(Some(5))(_ > 2)) // Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None
  println(map(Some(5))(_ > 2)) // Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None


