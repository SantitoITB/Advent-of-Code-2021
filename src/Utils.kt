import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("puzzleInput", "$name.txt").readLines()

fun stringToIntList(data: String): List<Int> = data.removeSurrounding("[","]").replace(" ","").split(",").map { it.toInt() }
