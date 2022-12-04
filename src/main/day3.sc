import scala.io.Source

val data = util.Using.resource(Source.fromFile("/Users/richard_pryce/workspace/AdventOfCode2022/src/main/input/day3"))(_.mkString)
val input = data.split("\n").toList
//val input = "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw".split("\n")

object day3 {
  def solution: String = {
    def part1(): Int = {
      var total = 0
      for (content <- input) {
        val itemA = content.substring(0, content.length / 2)
        val itemB = content.substring(content.length / 2, content.toString.length)
        val char = getUniqueLetter(itemA, itemB)
        total += getCharValue(char)
      }
      total
    }

    def getCharValue(char: Char): Int = {
      var value = 0
      if (char.isLower) value += char.toInt - 96
      if (char.isUpper) value += char.toInt - 38
      value
    }

    def getUniqueLetter(a: String, b: String): Char = {
      for (letter <- a) {
        if (b.contains(letter)) return letter
      }
      '_'
    }

    def part2(): Int = {
      var score = 0
      for (i <- Range(0, input.length, 3)) {
        for (char <- input(i).distinct) {
          if (input(i+1).contains(char) && input(i+2).contains(char)) {
            score += getCharValue(char)
          }
        }
      }
      score
    }
    s"Part1: ${part1}\nPart2: ${part2}"
  }

}
day3.solution