package rational

import org.scalatest.FunSuite

class RationalSuite extends FunSuite {

  test("Add 1"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,6D)
    assert(a+b == new Rational(29,6))
  }
  test("Add 2"){
    val a = new Rational(-10D,4D)
    val b = new Rational(14D,6D)
    assert(a+b == new Rational(-1,6))
  }
  test("Add 3"){
    val a = new Rational(10D,-4D)
    val b = new Rational(14D,6D)
    assert(a+b == new Rational(-1,6))
  }
  test("Add 4"){
    val a = new Rational(10D,4D)
    val b = new Rational(-14D,6D)
    assert(a+b == new Rational(1,6))
  }
  test("Add 5"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,-6D)
    assert(a+b == new Rational(1,6))
  }


}
