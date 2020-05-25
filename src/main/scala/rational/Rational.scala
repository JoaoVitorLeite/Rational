package rational

import Num.Implicits._

/***
 *
 * @param num
 * @param den
 * @param op
 * @tparam A
 */
class Rational[A](val num: A, val den: A)(implicit op: Num[A]){
  /***
   *
   */
  require(den != 0, "The denominator must be different of zero")
  /***
   *
   */
  require(den != 0 && num != 0, "The rational must be diferent of zero")

  /***
   *
   * @param nume
   * @param op
   */
  def this(nume: A)(implicit op: Num[A]){
    this(nume, op.one)
  }

  /***
   *
   * @param x
   * @param y
   * @return
   */
  @scala.annotation.tailrec
  private def gcd(x:A, y:A): A = if(y == 0) x else gcd(y, x%y)

  /***
   *
   */
  private val g: A = gcd(op.abs(num), op.abs(den))
  /***
   *
   */
  private val res = (num, den) match {
    case (_,b) if op.abs(b) != b => (-num/g, -den/g)
    case _ => (num/g, den/g)
  }
  /***
   *
   */
  private val n: A = res._1
  /***
   *
   */
  private val d: A = res._2

  /***
   *
   * @param other
   * @return
   */
  def + (other: Rational[A]): Rational[A] = new Rational(n*other.d + d*other.n, d*other.d)

  /***
   *
   * @return
   */
  def unary_- : Rational[A] = new Rational(-n, d)

  /***
   *
   * @param other
   * @return
   */
  def - (other: Rational[A]): Rational[A] = this + -other

  /***
   *
   * @param other
   * @return
   */
  def * (other: Rational[A]): Rational[A] = new Rational(n*other.n, d*other.d)

  /***
   *
   * @return
   */
  def inverse: Rational[A] = new Rational(d,n)

  /***
   *
   * @param other
   * @return
   */
  def / (other: Rational[A]): Rational[A] = this * other.inverse

  /***
   *
   * @return
   */
  def square: Rational[A] = new Rational(n*n,d*d)

  /***
   *
   * @return
   */
  def squareRoot: Rational[A] = new Rational(op.sqroot(n), op.sqroot(d))

  /***
   *
   * @return
   */
  override def toString: String = s"$n/$d"

  /***
   *
   * @param obj
   * @return
   */
  override def equals(obj: Any): Boolean = obj match {
    case r: Rational[A] => if((r.n == this.n) && (r.d == this.d)) true else false
    case _ => false
  }
}
