//  --- Day 4: Giant Squid ---

data class Marked(val column : Int, val board: Int, val row: Int, val value: Int)

fun main() {
    val input = readInput("day04").map { it -> it.split(" ").filter { it.isNotEmpty() } }
    val randomOrder : List<Int> = stringToIntList(input[0][0])
    val boards : List<List<List<Int>>> = extractBoards(input)
    println(part1(randomOrder,boards))
    println(part2(randomOrder,boards))
}

fun part1(randomOrder : List<Int>, boards : List<List<List<Int>>>): Int {
    val markeds = mutableListOf<Marked>()
    for (i in randomOrder){
        for (board in boards){
            for (row in board){
                for (value in row){
                    if (value == i){
                        markeds.add(Marked(row.indexOf(value),boards.indexOf(board),board.indexOf(row),value))
                        for (m in markeds){
                            if (markeds.filter { it.row  == board.indexOf(row) && it.board == boards.indexOf(board)}.size == 5){
                                val winnerBoard = markeds.filter { it.row  == board.indexOf(row) && it.board == boards.indexOf(board)}[0].board
                                val markedSoFar = markeds.map { it.value }.toSet()
                                val unmarkeds = boards[winnerBoard].map { it.filter { it !in markedSoFar } }
                                return (unmarkeds.sumOf { it.sum() }) * value
                            }
                            if (markeds.filter { it.column  == row.indexOf(value) && it.board == boards.indexOf(board)}.size == 5){
                                val winnerBoard = markeds.filter { it.column  == row.indexOf(value) && it.board == boards.indexOf(board)}[0].board
                                val markedSoFar = markeds.map { it.value }.toSet()
                                val unmarkeds = boards[winnerBoard].map { it.filter { it !in markedSoFar } }
                                return (unmarkeds.sumOf { it.sum() }) * value
                            }
                        }
                    }
                }
            }
        }
    }
    return -1
}

fun part2(randomOrder : List<Int>, boards : List<List<List<Int>>>): Int {
    val markeds = mutableListOf<Marked>()
    val winnerToLoser = mutableListOf<Int>()
    for (i in randomOrder){
        for (board in boards){
            for (row in board){
                for (value in row){
                    if (value == i){
                        markeds.add(Marked(row.indexOf(value),boards.indexOf(board),board.indexOf(row),value))
                        for (m in markeds){
                            if (markeds.filter { it.row  == board.indexOf(row) && it.board == boards.indexOf(board)}.size == 5){
                                val winnerBoard = markeds.filter { it.row  == board.indexOf(row) && it.board == boards.indexOf(board)}[0].board
                                if (winnerBoard !in winnerToLoser) winnerToLoser.add(winnerBoard)
                                if (winnerToLoser.indices == boards.indices){
                                    val markedSoFar = markeds.map { it.value }.toSet()
                                    val unmarkeds = boards[winnerToLoser.last()].map { it.filter { it !in markedSoFar } }
                                    return unmarkeds.sumOf { it.sum() } * value
                                }
                            }
                            if (markeds.filter { it.column  == row.indexOf(value) && it.board == boards.indexOf(board)}.size == 5){
                                val winnerBoard = markeds.filter { it.column  == row.indexOf(value) && it.board == boards.indexOf(board)}[0].board
                                if (winnerBoard !in winnerToLoser) winnerToLoser.add(winnerBoard)
                                if (winnerToLoser.indices == boards.indices){
                                    val markedSoFar = markeds.map { it.value }.toSet()
                                    val unmarkeds = boards[winnerToLoser.last()].map { it.filter { it !in markedSoFar } }
                                    return unmarkeds.sumOf { it.sum() } * value
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return -1
}

fun stringToIntList(data: String): List<Int> = data.removeSurrounding("[","]").replace(" ","").split(",").map { it.toInt() }

fun extractBoards(input: List<List<String>>): List<List<List<Int>>> {
    val boards = mutableListOf<List<String>>()
    var board = mutableListOf<String>()
    var boardLength = 0
    for (i in 2..input.lastIndex) if (input[i].isNotEmpty()){
        board.add(input[i].toString())
        boardLength++
        if (boardLength != 5) continue
        boards.add(board)
        board = mutableListOf()
        boardLength = 0
    }
    return boards.map { list -> list.map { stringToIntList(it) }}
    //return boards.map {it.toList().map { it.toInt() }  }
}