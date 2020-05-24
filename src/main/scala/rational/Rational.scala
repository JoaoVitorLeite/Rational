package rational

class Rational[A](val num: A, val den: A)(implicit op: Num[A]){
  require(den != 0, "The denominator must be different of zero")
  require(den != 0 && num != 0, "The rational must be diferent of zero")
  def this(nume: A)(implicit op: Num[A]){
    this(nume, op.one)
  }

  @scala.annotation.tailrec
  private def gcd(x:A, y:A): A = if(y == 0) x else gcd(y, op.%(x,y))
  val g: A = gcd(num, den)
  val n: A = op./(num,g)
  val d: A = op./(den,g)

  def + (other: Rational[A]): Rational[A] =




  override def toString: String = s"$n/$d"
}
