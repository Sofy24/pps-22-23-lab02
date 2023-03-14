package u02

object Shapes extends App:
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

  println(perimeter(Square(4, (0.0, 1.0))))
  println(perimeter(Circle(4, (0,1))))
  println(perimeter(Rectangle(4, 2, (0,1))))

  println(contains(Square(4, (0.0, 0.0)), (2.0, 2.0)))
  println(contains(Square(4, (0.0, 0.0)), (5.0, 2.0)))
  println(contains(Circle(4, (0,1)), (3.0, 3.0)))
  println(contains(Circle(4, (0,1)), (3.0, 6.0)))
  println(contains(Rectangle(4, 2, (0,1)), (1.0, 1.0)))
  println(contains(Rectangle(4, 2, (0,1)), (1.0, 4.0)))
