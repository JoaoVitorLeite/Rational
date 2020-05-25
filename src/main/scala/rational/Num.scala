package rational

trait Num[A]{
  def plus (x:A, y:A): A
  def sub(x:A, y:A): A
  def mul(x:A, y:A): A
  def div(x:A, y:A): A
  def rm(x:A, y:A): A
  def zero: A
  def one: A
  def neg(x:A): A
  def sqroot(x:A): A
  def abs(x:A): A

  class Ops(lhs: A){

    def + (rhs: A): A = plus(lhs, rhs)
    def unary_- : A = neg(lhs)
    def - (rhs: A): A = sub(lhs, rhs)
    def * (rhs: A): A = mul(lhs, rhs)
    def / (rhs: A): A = div(lhs, rhs)
    def % (rhs: A): A = rm(lhs, rhs)
  }

  implicit def mkNumOps(lhs: A): Ops = new Ops(lhs)

}


object Num {

  trait ExtraImplicits{

    implicit def infixNumOps[A](x:A)(implicit num: Num[A]): Num[A]#Ops = new num.Ops(x)

  }

  object Implicits extends ExtraImplicits { }

  trait IntNum extends Num[Int]{
    override def plus(x: Int, y: Int): Int = x+y

    override def sub(x: Int, y: Int): Int = x-y

    override def mul(x: Int, y: Int): Int = x*y

    override def div(x: Int, y: Int): Int = x/y

    override def zero: Int = 0

    override def one: Int = 1

    override def rm(x: Int, y: Int): Int = x%y

    override def neg(x: Int): Int = -x

    override def sqroot(x: Int): Int = math.sqrt(x).toInt

    override def abs(x: Int): Int = if(x < 0) -x else x
  }

  implicit object IntNum extends IntNum with Ordering.IntOrdering

  trait FloatNum extends Num[Float]{
    override def plus(x: Float, y: Float): Float = x+y

    override def sub(x: Float, y: Float): Float = x-y

    override def mul(x: Float, y: Float): Float = x*y

    override def div(x: Float, y: Float): Float = x/y

    override def zero: Float = 0f

    override def one: Float = 1f

    override def rm(x: Float, y: Float): Float = x%y

    override def neg(x: Float): Float = -x

    override def sqroot(x: Float): Float = math.sqrt(x).toFloat

    override def abs(x: Float): Float = if(x < 0) -x else x
  }

  implicit object FloatNum extends FloatNum with Ordering.Float.TotalOrdering

  trait DoubleNum extends Num[Double]{
    override def plus(x: Double, y: Double): Double = x+y

    override def sub(x: Double, y: Double): Double = x-y

    override def mul(x: Double, y: Double): Double = x*y

    override def div(x: Double, y: Double): Double = x/y

    override def zero: Double = 0D

    override def one: Double = 1D

    override def rm(x: Double, y: Double): Double = x%y

    override def neg(x: Double): Double = -x

    override def sqroot(x: Double): Double = math.sqrt(x)

    override def abs(x: Double): Double = if(x < 0) -x else x

  }

  implicit object DoubleNum extends DoubleNum with Ordering.Double.TotalOrdering

  trait LongNum extends Num[Long]{
    override def plus(x: Long, y: Long): Long = x+y

    override def sub(x: Long, y: Long): Long = x-y

    override def mul(x: Long, y: Long): Long = x*y

    override def div(x: Long, y: Long): Long = x/y

    override def zero: Long = 0L

    override def one: Long = 1L

    override def rm(x: Long, y: Long): Long = x%y

    override def neg(x: Long): Long = -x

    override def sqroot(x: Long): Long = math.sqrt(x.toDouble).toLong

    override def abs(x: Long): Long = if(x < 0) -x else x
  }

  implicit object LongNum extends LongNum with Ordering.LongOrdering
}
