package u02
import org.junit.*
import org.junit.Assert.*
import Negative.*

class NegativeTest:
  val empty: String => Boolean = _ == ""
  val notEmpty = neg3(empty)
  val zero: Integer => Boolean = _ == 0
  val notZero = neg3(zero)

  @Test def testString() =
    assertTrue(notEmpty2("foo"))
    assertFalse(notEmpty2(""))
    assertTrue(notEmpty2("foo") && !notEmpty2(""))

  @Test def testInteger() =
    assertTrue(notZero(2))
    assertFalse(notZero(0))
    assertTrue(notZero(1) && !notZero(0))

