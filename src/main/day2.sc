import scala.io.Source
object day2 {
//var input = "A Y\nB X\nC Z".split("\n").toList
val data = util.Using.resource(Source.fromFile("/Users/richard_pryce/workspace/AdventOfCode2022/src/main/input/day2"))(_.mkString)
val input = data.split("\n").toList
  def solution(): String = {

    def part1: String ={
      var score = 0
      for (round <- input) {
        round match {
          case "A Z" | "B X" | "C Y" => score += 0
          case "A X" | "B Y" | "C Z" => score += 3
          case "A Y" | "B Z" | "C X" => score += 6
        }
        round.charAt(2).toString match {
          case "X" => score += 1
          case "Y" => score += 2
          case "Z" => score += 3
        }
      }
      s"Part 1: ${score}"
    }

    def part2(): String = {
      var score = 0
      for (round <- input) {
        round.charAt(2).toString match {
          case "X" => round.charAt(0).toString match {
            case "A" => score += 3
            case "B" => score += 1
            case "C" => score += 2
          }
          case "Y" => round.charAt(0).toString match {
            case "A" => score += 4
            case "B" => score += 5
            case "C" => score += 6
          }
          case "Z" => round.charAt(0).toString match {
            case "A" => score += 8
            case "B" => score += 9
            case "C" => score += 7
          }
        }
      }
      s"Part 2: ${score}"
    }

    part1+"\n"+part2

  }
}

day2.solution()
