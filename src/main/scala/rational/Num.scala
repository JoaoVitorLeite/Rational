package rational

trait Num[A]{
  def + (x:A, y:A): A
  def - (x:A, y:A): A
  def * (x:A, y:A): A
  def / (x:A, y:A): A
  def zero: A
  def one: A
}


object Num {

  implicit object IntNum extends Num[Int]{
    override def +(x: Int, y: Int): Int = x+y

    override def -(x: Int, y: Int): Int = x-y

    override def *(x: Int, y: Int): Int = x*y

    override def /(x: Int, y: Int): Int = x/y

    override def zero: Int = 0

    override def one: Int = 1
  }

  implicit object FloatNum extends Num[Float]{
    override def +(x: Float, y: Float): Float = x+y

    override def -(x: Float, y: Float): Float = x-y

    override def *(x: Float, y: Float): Float = x*y

    override def /(x: Float, y: Float): Float = x/y

    override def zero: Float = 0f

    override def one: Float = 1f
  }

  implicit object DoubleNum extends Num[Double]{
    override def +(x: Double, y: Double): Double = x+y

    override def -(x: Double, y: Double): Double = x-y

    override def *(x: Double, y: Double): Double = x*y

    override def /(x: Double, y: Double): Double = x/y

    override def zero: Double = 0D

    override def one: Double = 1D
  }

  implicit object LongNum extends Num[Long]{
    override def +(x: Long, y: Long): Long = x+y

    override def -(x: Long, y: Long): Long = x-y

    override def *(x: Long, y: Long): Long = x*y

    override def /(x: Long, y: Long): Long = x/y

    override def zero: Long = 0L

    override def one: Long = 1L
  }

}
