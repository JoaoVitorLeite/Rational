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
  ///
  test("Sub 1"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,6D)
    assert(a-b == new Rational(1,6))
  }
  test("Sub 2"){
    val a = new Rational(-10D,4D)
    val b = new Rational(14D,6D)
    assert(a-b == new Rational(-29,6))
  }
  test("Sub 3"){
    val a = new Rational(10D,-4D)
    val b = new Rational(14D,6D)
    assert(a-b == new Rational(-29,6))
  }
  test("Sub 4"){
    val a = new Rational(10D,4D)
    val b = new Rational(-14D,6D)
    assert(a-b == new Rational(29,6))
  }
  test("Sub 5"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,-6D)
    assert(a-b == new Rational(29,6))
  }
  ///
  test("Unary"){
    val a = new Rational(1,5)
    assert(-a == new Rational(-1,5))
  }
  ///
  test("Mul 1"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,6D)
    assert(a*b == new Rational(35,6))
  }
  test("Mul 2"){
    val a = new Rational(-10D,4D)
    val b = new Rational(14D,6D)
    assert(a*b == new Rational(-35,6))
  }
  test("Mul 3"){
    val a = new Rational(10D,-4D)
    val b = new Rational(14D,6D)
    assert(a*b == new Rational(-35,6))
  }
  test("Mul 4"){
    val a = new Rational(10D,4D)
    val b = new Rational(-14D,6D)
    assert(a*b == new Rational(-35,6))
  }
  test("Mul 5"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,-6D)
    assert(a*b == new Rational(-35,6))
  }
  ///
  test("Div 1"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,6D)
    assert(a/b == new Rational(15,14))
  }
  test("Div 2"){
    val a = new Rational(-10D,4D)
    val b = new Rational(14D,6D)
    assert(a/b == new Rational(-15,14))
  }
  test("Div 3"){
    val a = new Rational(10D,-4D)
    val b = new Rational(14D,6D)
    assert(a/b == new Rational(-15,14))
  }
  test("Div 4"){
    val a = new Rational(10D,4D)
    val b = new Rational(-14D,6D)
    assert(a/b == new Rational(-15,14))
  }
  test("Div 5"){
    val a = new Rational(10D,4D)
    val b = new Rational(14D,-6D)
    assert(a/b == new Rational(-15,14))
  }
  ///
  test("Inverse"){
    val a = new Rational(5,8)
    assert(a.inverse == new Rational(8,5))
  }
  ///
  test("Equals"){
    val a = new Rational(2E24, 1E17)
    assert(a == new Rational(2E24, 1E17))
  }
  ///
  test("Square"){
    val a = new Rational(3,4)
    assert(a.square == new Rational(9,16))
  }
  ///
  test("Square root"){
    val a = new Rational(9,16)
    assert(a.squareRoot == new Rational(3,4))
  }
}
