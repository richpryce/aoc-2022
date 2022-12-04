import scala.io.Source
import scala.collection.mutable.ListBuffer

object day1 {

val input = util.Using.resource(Source.fromFile("/Users/richard_pryce/workspace/AdventOfCode2022/src/main/input/day1"))(_.mkString)


  def solution(): String = {
    var max = 0
    val maxList = ListBuffer[Int]()
    var totalCalories = 0
    val inputList: List[String] = input.split("\n\n").toList
    for (item <- inputList) {
      val food = item.split("\n").toList.map(f => f.toInt)
      for (calories <- food) {
        totalCalories += calories
      }
      if (totalCalories > max) max = totalCalories
      maxList.append(totalCalories)
      totalCalories = 0
    }
    s"""Part one: $max
    Part two: ${maxList.sorted.takeRight(3).sum}
     """
  }
}

println(day1.solution())
