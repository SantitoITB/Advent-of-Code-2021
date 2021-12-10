//  --- Day 6: Lanternfish ---

fun main() {
   fun part1(input: List<Int>) {
      var lanterns : MutableList<Int> = input.toMutableList()
      for (i in 0..18){
         for (element in lanterns) if (element == 0) {
            lanterns[lanterns.indexOf(element)] = 7
            //lanterns.add(8)
         }
         lanterns = lanterns.map { it - 1 }.toMutableList()
         println(lanterns)
      }
      //println(lanterns)
   }

   fun part2(input: List<Int>): List<Int> {
      return input
   }

   val input = readInput("day06").first().split(",").map { it.toInt() }
   println(part1(input))
   //println(part2(input))

}

