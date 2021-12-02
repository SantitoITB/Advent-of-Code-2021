fun main() {
    fun part1(input: List<Int>): Int {
        var increased = 0
    for (i in 1..list.lastIndex) {
        if (list[i] > list[i-1]){
            increased++
        }
    }
    return increased

    }

    fun part2(input: List<String>): Int {
        return input.size
    }
   
    val input = readFileToIntList(Path = "data/adventOfCode/Sonar_Sweep.txt")
    println(part1(input))
    println(part2(input))
}
