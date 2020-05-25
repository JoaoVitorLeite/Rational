# Rational

### Description
Class to represent rational numbers in Scala. A rational number is a number that can be expressed as a quotient or a fraction `p/q` of two integers, `p` being the numerator and `q` the denominator, where `q` should be different from zero. For example, the image below shows a rational number where the numerator is 2 and the denominator is 5.

<p align="center">
  <img src="https://github.com/JoaoVitorLeite/Rational/blob/master/download.png">
</p>


### About

This class was implemented using a generic type, which was implemented [here](https://github.com/JoaoVitorLeite/Rational/blob/master/src/main/scala/rational/Num.scala), which supports some basic algebraic operations and is defined for types Int, Float, Double, Long. The tests made are of simple character, and for this the [Scala Test](https://www.scalatest.org/) was used. In total ?? tests were performed.

### Project Structure

```bash
Rational
|
|
|
|
\--src
|   |
|   |
|   \---main
|   |   \---scala
|   |       \---rational
|   |               Main.scala
|   |               Num.scala
|   |               Rational.scala
|   |
|   \---test
|       \---scala
|           \---rational
|                   RationalSuite.scala
|
|
+---.gitignore
     LICENSE
     README.md
     download.png
```

### Test

To perform the tests it is necessary to be in the root directory(where the build.sbt file is), then use the `sbt test` command


### References

* [Link](https://www.mathsisfun.com/algebra/rational-numbers-operations.html)
* [Link](https://byjus.com/maths/rational-numbers/)


### License
The LICENSE used is [Apache-2.0](https://github.com/JoaoVitorLeite/Rational/blob/master/LICENSE)
