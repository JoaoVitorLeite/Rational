package rational

import Num.Implicits._

class Rational[A](val num: A, val den: A)(implicit op: Num[A]){
  require(den != 0, "The denominator must be different of zero")
  require(den != 0 && num != 0, "The rational must be diferent of zero")
  def this(nume: A)(implicit op: Num[A]){
    this(nume, op.one)
  }

  @scala.annotation.tailrec
  private def gcd(x:A, y:A): A = if(y == 0) x else gcd(y, x%y)
  private val g: A = gcd(num, den)
  private val n: A = num/g
  private val d: A = den/g
  def + (other: Rational[A]): Rational[A] = new Rational(n*other.d + d*other.n, d*other.d)
  def unary_- : Rational[A] = new Rational(-n, d)
  def - (other: Rational[A]): Rational[A] = this + -other
  def * (other: Rational[A]): Rational[A] = new Rational(n*other.n, d*other.d)
  def inverse: Rational[A] = new Rational(d,n)
  def / (other: Rational[A]): Rational[A] = this * other.inverse
  def square: Rational[A] = new Rational(n*n,d*d)
  def squareRoot: Rational[A] = new Rational(op.sqroot(n), op.sqroot(d))
  override def toString: String = s"$n/$d"
  override def equals(obj: Any): Boolean = obj match {
    case r: Rational[A] => if((r.n == this.n) && (r.d == this.d)) true else false
    case _ => false
  }
}
