package rational

import Num.Implicits._

/***
 * @author João Vitor Leite
 */

/***
 * Class to represent rational numbers in Scala
 *
 * @param num Numerator
 * @param den Denominator
 * @param op  Implicit type class created(Nothing needs to be passed, delete the `[]`)
 * @tparam A Type class
 */
class Rational[A](val num: A, val den: A)(implicit op: Num[A]){

  /***
   * <p>
   *   Note: Require to verify that the denominator is other than zero
   * </p>
   */
  require(den != 0, "The denominator must be different of zero")
  /***
   * <p>
   *   Note: Require to verify that the denominator and numerator are different from zero
   */
  require(den != 0 && num != 0, "The rational must be diferent of zero")

  /***
   * Auxiliary constructor that receives the numerator and defines the denominator as 1
   * @param nume Numerator
   * @param op Implicit type class created
   */
  def this(nume: A)(implicit op: Num[A]){
    this(nume, op.one)
  }

  /***
   * Algorithm to calculate the greatest common divisor
   * @param x A positive number
   * @param y A positive number
   * @return The greatest common divisor
   */
  @scala.annotation.tailrec
  private def gcd(x:A, y:A): A = if(y == 0) x else gcd(y, x%y)

  /***
   * <p>
   *   Note: In order not to change the rational number the numerator and denominator module has been passed
   * </p>
   */
  private val g: A = gcd(op.abs(num), op.abs(den))
  /***
   * <p>
   *   Note: Check to put the possible negative sign in the numerator
   * </p>
   */
  private val res = (num, den) match {
    case (_,b) if op.abs(b) != b => (-num/g, -den/g)
    case _ => (num/g, den/g)
  }
  /***
   * <p>
   *   Note: Numerator after simplifying the rational number and standardizing the signal
   * </p>
   */
  private val n: A = res._1
  /***
   * <p>
   *   Note: Denominator after simplifying the rational number and standardizing the signal
   * </p>
   */
  private val d: A = res._2

  /***
   * Method for applying the addition of two rational numbers
   * @param other A rational number
   * @return The sum of the two rational numbers
   */
  def + (other: Rational[A]): Rational[A] = new Rational(n*other.d + d*other.n, d*other.d)

  /***
   * Method for returning the negative rational number
   * @return A rational number
   */
  def unary_- : Rational[A] = new Rational(-n, d)

  /***
   * Method for appluing the subtraction of two rational numbers
   * @param other A rational number
   * @return The subtraction of the two rational numbers
   */
  def - (other: Rational[A]): Rational[A] = this + -other

  /***
   * Method for applying the multiplication of two rational numbers
   * @param other A rational number
   * @return The multiplication of two rational numbers
   */
  def * (other: Rational[A]): Rational[A] = new Rational(n*other.n, d*other.d)

  /***
   * Method for applying the multiplication by a constant
   * @param other Any number
   * @return A rational number
   */
  def * (other: A): Rational[A] = new Rational(other*n,d)

  /***
   * Method for applying the power of a rational number
   * @param other Power to be applied
   * @return A rational number
   */
  def pow(other: A): Rational[A] = new Rational(op.pow(n,other), op.pow(d,other))

  /***
   * Method to return the inverse of the rational number
   * @return A rational number
   */
  def inverse: Rational[A] = new Rational(d,n)

  /***
   * Method for applying the division of two rational numbers
   * @param other A rational number
   * @return The division of two rational numbers
   */
  def / (other: Rational[A]): Rational[A] = this * other.inverse

  /***
   * Method to return the square of the rational number
   * @return A rational number
   */
  def square: Rational[A] = new Rational(n*n,d*d)

  /***
   * Method to return the square root of the rational number
   * @return A rational number
   */
  def squareRoot: Rational[A] = new Rational(op.sqroot(n), op.sqroot(d))

  /***
   * Method for comparing rational numbers
   * @param other A rational number
   * @return It returns true if a rational number is less than that the other
   */
  def < (other: Rational[A]): Boolean = if((n/d) < (other.n/other.d)) true else false

  /***
   * Method for comparing rational numbers
   * @param other A rational number
   * @return It returns true if a rational number is less than or equal that the other
   */
  def <= (other: Rational[A]): Boolean = if((n/d) <= (other.n/other.d)) true else false

  /***
   * Method for comparing rational numbers
   * @param other A rational number
   * @return It returns true if a rational number is greater than that the other
   */
  def > (other: Rational[A]): Boolean = if((n/d) > (other.n/other.d)) true else false

  /***
   * Method for comparing rational numbers
   * @param other A rational number
   * @return It returns true if a rational number is greater than or equal that the other
   */
  def >= (other: Rational[A]): Boolean = if((n/d) >= (other.n/other.d)) true else false

  /***
   * Method to return the rational number in string format
   * @return Rational number as string
   */
  override def toString: String = {
    val aux = gcd(n,d)
    s"${n/aux}/${d/aux}"
  }

  /***
   * Method to check if two rational numbers are equal
   * @param obj Any object
   * @return Returns true if the rational numbers are equal, otherwise false
   */
  override def equals(obj: Any): Boolean = obj match {
    case r: Rational[A] => if((r.n == this.n) && (r.d == this.d)) true else false
    case _ => false
  }
}
