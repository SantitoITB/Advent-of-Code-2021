//  --- Day 2: Dive! ---


data class Command(val name: String, val value: Int)

fun main() {
    val input = readInput("day02").map { val (name, value) = it.split(" ");Command(name,value.toInt())}
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<Command>): Int {
        var depth = 0
        var horizontal = 0
        for (i in input){
            when (i.name){
                "forward" -> horizontal += i.value
                "down" -> depth += i.value
                "up" -> depth -= i.value
            }
        }
        return depth*horizontal
}

fun part2(input: List<Command>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0
        for (i in input){
            when (i.name){
                "forward" -> {
                    horizontal += i.value
                    depth += i.value * aim
                }
                "down" -> aim += i.value
                "up" -> aim -= i.value
            }
        }
        return depth*horizontal

}
