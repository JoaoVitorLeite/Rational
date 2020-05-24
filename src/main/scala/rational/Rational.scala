package rational

class Rational[A](val num: A, val den: A)(implicit op: Num[A]){
  require(den != 0, "The denominator must be different of zero")
  require(den != 0 && num != 0, "The rational must be diferent of zero")
  def this(num: A){
    this(num, op.one)
  }




}
