//  --- Day 1: Sonar Sweep ---

fun main() {
    fun part1(input: List<Int>): Int {
        var increased = 0
        for (i in 1..input.lastIndex) {
            if (input[i] > input[i-1]) increased++
        }
    return increased
    }

    fun part2(input: List<Int>): Int {
        val secondlist = mutableListOf<Int>()
        for (i in 2..input.lastIndex){
            secondlist.add(input[i]+input[i-1]+input[i-2])
        }
        return part1(secondlist)
    }

    val input = readInput("day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
