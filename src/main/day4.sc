import scala.io.Source
//val input = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8".split("\n")
val data = util.Using.resource(Source.fromFile("/Users/richard_pryce/workspace/AdventOfCode2022/src/main/input/day4"))(_.mkString)
val input = data.split("\n").toList
object day4 {
  def solution: String ={
    val pairsArray = new Array[Int](4)
    
    def part1: String ={
    var total = 0
      for (line <- input){
        val l = seperatePairs(line)
        if ((l(0) >= l(2) && l(1) <= l(3)) ||
        (l(0) <= l(2) && l(1) >= l(3))) {
          total += 1
        }
      }
      s"Part1: ${total}"
    }
    def part2: String ={
      var total = 0
      for (line <- input) {
        val l = seperatePairs(line)
        val pairALow = l(0)
        val pairAHigh = l(1)
        val pairBLow = l(2)
        val pairBHigh = l(3)

        if (pairAHigh >= pairBLow && pairALow <= pairBHigh ||
          pairBHigh <= pairALow && pairAHigh <= pairBLow) {
          total += 1
        }
      }
      s"Part2: ${total}"
    }

    def seperatePairs(pair: String): Array[Int] = {
      val splitPair = pair.split(",")
      val pairA = splitPair(0).split("-")
      val pairB = splitPair(1).split("-")
      pairsArray(0) = pairA(0).toInt
      pairsArray(1) = pairA(1).toInt
      pairsArray(2) = pairB(0).toInt
      pairsArray(3) = pairB(1).toInt
    pairsArray
    }
    part1 + "\n" +  part2
  }
}

println(day4.solution)